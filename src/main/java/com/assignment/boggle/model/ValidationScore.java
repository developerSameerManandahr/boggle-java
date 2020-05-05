package com.assignment.boggle.model;

/**
 * score model for word validation and calculation
 */
public class ValidationScore {
    private boolean isValid;
    private int score;

    public ValidationScore(boolean isValid, int score) {
        this.isValid = isValid;
        this.score = score;
    }

    public ValidationScore() {
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
