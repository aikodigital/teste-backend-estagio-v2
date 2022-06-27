package com.estagio.aiko.equipments.api.application.shared.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public abstract class BaseExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	public String makeSourceMessage(String sourceMessage) {
		return messageSource.getMessage(sourceMessage, null, LocaleContextHolder.getLocale());
	}

	public List<ErrorMessage> makeResponseBody(String message, String cause, HttpStatus status) {
		return Arrays.asList(new ErrorMessage(message, cause, status.value(), LocalDateTime.now()));
	}

	public List<ErrorMessage> makeErrorList(BindingResult bindingResult, HttpStatus status) {

		List<ErrorMessage> errors = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {

			String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String cause = fieldError.toString();

			errors.add(new ErrorMessage(message, cause, status.value(), LocalDateTime.now()));
		}

		return errors;
	}

}
