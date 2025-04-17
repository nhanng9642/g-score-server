package com.nhan.gscore.domain.exception;

public class ScoreNotFoundException extends RuntimeException {
    private final static String MESSAGE = "Score with id %d not found";
    public ScoreNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
