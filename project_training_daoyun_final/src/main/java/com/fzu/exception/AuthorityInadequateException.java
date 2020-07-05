package com.fzu.exception;

public class AuthorityInadequateException extends Exception {
    private String message;

    public AuthorityInadequateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
