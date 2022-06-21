package io.github.pedrobicudo.testebackendestagiov2.rest.advice;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.HourlyEarningsNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.InvalidHourlyEarningsIdException;
import io.github.pedrobicudo.testebackendestagiov2.rest.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HourlyEarningsControllerAdvice {

    @ExceptionHandler(HourlyEarningsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handleHourlyEarningsNotFoundException(HourlyEarningsNotFoundException exception) {
        return new APIError(exception.getMessage());
    }

    @ExceptionHandler(InvalidHourlyEarningsIdException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public APIError handleInvalidHourlyEarningsIdException(InvalidHourlyEarningsIdException exception) {
        return new APIError(exception.getMessage());
    }

}
