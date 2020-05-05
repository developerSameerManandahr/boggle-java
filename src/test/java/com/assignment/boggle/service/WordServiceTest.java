package com.assignment.boggle.service;

import com.assignment.boggle.model.ValidationScore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WordServiceTest {

    private RestTemplate restTemplate = mock(RestTemplate.class);

    private WordService wordService = new WordServiceImpl(restTemplate);

    @Test
    public void should_validate_correct_word() {
        String validWord = "word";
        final HashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("word", "word");
        linkedHashMap.put("score", "5385");
        when(restTemplate.getForObject("https://api.datamuse.com/sug?s=" + validWord, List.class))
                .thenReturn(Collections.singletonList(linkedHashMap));
        ValidationScore validationScore = wordService.validateAndCalculateScore(validWord);
        assertTrue(validationScore.isValid());
        assertEquals(validationScore.getScore(), 4);
    }

    @Test
    public void should_validate_wrong_word() {
        String invalidWord = "xyza";
        final HashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        when(restTemplate.getForObject("https://api.datamuse.com/sug?s=" + invalidWord, List.class))
                .thenReturn(Collections.singletonList(linkedHashMap));
        ValidationScore validationScore = wordService.validateAndCalculateScore(invalidWord);
        assertFalse(validationScore.isValid());
        assertEquals(validationScore.getScore(), 4);
    }
}
