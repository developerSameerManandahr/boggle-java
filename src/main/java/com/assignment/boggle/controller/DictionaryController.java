package com.assignment.boggle.controller;

import com.assignment.boggle.model.ValidationScore;
import com.assignment.boggle.service.WordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final WordService wordService;

    public DictionaryController(WordService wordService) {
        this.wordService = wordService;
    }

    @CrossOrigin
    @GetMapping("/")
    public ValidationScore checkWord(@RequestParam String word){
        return wordService.validateAndCalculateScore(word);
    }
}
