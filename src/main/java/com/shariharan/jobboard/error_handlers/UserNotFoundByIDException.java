package com.shariharan.jobboard.error_handlers;

public class UserNotFoundByIDException extends Exception {
    public UserNotFoundByIDException(String message) {
        super(message);
    }
}