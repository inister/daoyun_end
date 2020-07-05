package com.fzu.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public String ex(Exception e) {
        return e.getMessage();
    }
}
