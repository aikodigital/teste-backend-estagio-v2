package com.estagio.aiko.equipments.api.application.equipment.handler;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.estagio.aiko.equipments.api.application.shared.exception.handler.BaseExceptionHandler;
import com.estagio.aiko.equipments.api.application.shared.exception.handler.ErrorMessage;
import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;

@ControllerAdvice
public class EquipmentExceptionHandler extends BaseExceptionHandler {

	// TODO: Handle custom exceptions

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> handleEquipmentModelNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = makeSourceMessage("resource.not-found");
		String cause = exception.getCause() != null ? exception.getCause().toString() : exception.toString();
		List<ErrorMessage> responseBody = makeResponseBody(message, cause, status);

		return handleExceptionInternal(exception, responseBody, new HttpHeaders(), status, request);
	}

}
