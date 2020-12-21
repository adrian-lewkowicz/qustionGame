package com.question.game.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String messeage){
        super(messeage);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
