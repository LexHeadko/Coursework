package com.example.coursework.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QuestionServiceException extends RuntimeException {
    public QuestionServiceException(String message) {
        super(message);
    }
}