package com.assignment.boggle.service;

import com.assignment.boggle.model.ValidationScore;

public interface WordService {

    /**
     * Validate word and calculate score
     * @param word String
     * @return ValidationScore
     */
    ValidationScore validateAndCalculateScore(String word);
}
