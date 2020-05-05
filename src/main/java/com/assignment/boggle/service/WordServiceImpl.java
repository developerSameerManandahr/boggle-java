package com.assignment.boggle.service;

import com.assignment.boggle.model.ValidationScore;
import com.assignment.boggle.model.WordScoreResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final RestTemplate restTemplate;

    public WordServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ValidationScore validateAndCalculateScore(String word) {
        List<LinkedHashMap<String, String>> results = restTemplate.getForObject("https://api.datamuse.com/sug?s=" + word, List.class);
        ObjectMapper objectMapper = new ObjectMapper();
        final TypeReference<List<WordScoreResult>> typeRef = new TypeReference<List<WordScoreResult>>() {};
        List<WordScoreResult> scoreResults = objectMapper.convertValue(results,typeRef);
        boolean isValid = false;
        if (results != null) {
            isValid = scoreResults
                    .stream()
                    .filter(wordScoreResult -> wordScoreResult.getScore() > 80)
                    .anyMatch(wordScoreResult -> word.toLowerCase().equals(wordScoreResult.getWord()));
        }
        return new ValidationScore(isValid, word.length());
    }
}
