package com.assignment.boggle.model;

/**
 *  Result after calling the datamuse suggestion API
 */
public class WordScoreResult {
    private String word;
    private int score;

    public WordScoreResult(String word, int score) {
        this.word = word;
        this.score = score;
    }

    public WordScoreResult() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
