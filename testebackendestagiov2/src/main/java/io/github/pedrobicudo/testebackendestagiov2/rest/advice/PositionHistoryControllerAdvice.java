package io.github.pedrobicudo.testebackendestagiov2.rest.advice;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidPositionHistoryIdException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.PositionHistoryNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.rest.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PositionHistoryControllerAdvice {

    @ExceptionHandler(PositionHistoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handlePositionHistoryNotFoundException(PositionHistoryNotFoundException exception) {
        return new APIError(exception.getMessage());
    }

    @ExceptionHandler(InvalidPositionHistoryIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleInvalidPositionHistoryIdException(InvalidPositionHistoryIdException exception) {
        return new APIError(exception.getMessage());
    }

}
