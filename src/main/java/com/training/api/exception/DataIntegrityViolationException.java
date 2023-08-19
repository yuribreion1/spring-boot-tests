package com.training.api.exception;

public class DataIntegrityViolationException extends RuntimeException {


    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
