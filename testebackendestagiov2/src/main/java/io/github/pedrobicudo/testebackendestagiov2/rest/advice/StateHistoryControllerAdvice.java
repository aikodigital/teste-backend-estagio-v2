package io.github.pedrobicudo.testebackendestagiov2.rest.advice;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidStateHistoryIdException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.StateHistoryNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.rest.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StateHistoryControllerAdvice {

    @ExceptionHandler(InvalidStateHistoryIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleInvalidStateHistoryIdException(InvalidStateHistoryIdException exception) {
        return new APIError(exception.getMessage());
    }

    @ExceptionHandler(StateHistoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handleStateHistoryNotFoundException(StateHistoryNotFoundException exception) {
        return new APIError(exception.getMessage());
    }

}
