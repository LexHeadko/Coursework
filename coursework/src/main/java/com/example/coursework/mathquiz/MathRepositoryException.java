package com.example.coursework.mathquiz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class MathRepositoryException extends RuntimeException {
    public MathRepositoryException(String message) {
        super(message);
    }
}