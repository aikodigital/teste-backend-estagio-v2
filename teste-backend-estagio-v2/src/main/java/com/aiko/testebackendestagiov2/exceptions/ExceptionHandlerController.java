package com.aiko.testebackendestagiov2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotFoundError.class)
    public ExceptionMessage handlerNotFind(NotFoundError e){
        return ExceptionMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Object not found.")
                .message(e.getMessage()).build();
    }
}
