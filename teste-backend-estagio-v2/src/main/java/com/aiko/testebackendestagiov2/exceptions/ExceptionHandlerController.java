package com.aiko.testebackendestagiov2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotFoundError.class)
    public ExceptionMessage handlerNotFoundError(NotFoundError e){
        return ExceptionMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Object not found.")
                .message(e.getMessage()).build();
    }

    @ExceptionHandler(BusinessException.class)
    public ExceptionMessage handlerBusinessException(BusinessException e){
        return ExceptionMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Business Exception.")
                .message(e.getMessage()).build();
    }
}
