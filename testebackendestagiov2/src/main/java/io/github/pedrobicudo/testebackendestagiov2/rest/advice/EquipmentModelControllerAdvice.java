package io.github.pedrobicudo.testebackendestagiov2.rest.advice;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.exceptions.EquipmentModelNotFoundException;
import io.github.pedrobicudo.testebackendestagiov2.rest.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EquipmentModelControllerAdvice {

    @ExceptionHandler(EquipmentModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handleEquipmentModelNotFoundException(EquipmentModelNotFoundException exception) {
        return new APIError(exception.getMessage());
    }

}
