package com.aiko.testebackendestagiov2.exceptions;

public class NotFoundError extends RuntimeException{
    public NotFoundError(String message) {
        super(message);
    }
}
