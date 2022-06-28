package com.estagio.aiko.equipments.api.application.shared.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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
		bindingResult.getFieldErrors().forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			String cause = e.toString();
			errors.add(new ErrorMessage(message, cause, status.value(), LocalDateTime.now()));
		});

		return errors;
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String message = makeSourceMessage("invalid.message");
		String cause = ex.getCause() != null ? ex.getCause().toString() : ex.toString();

		List<ErrorMessage> erros = makeResponseBody(message, cause, status);

		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErrorMessage> erros = makeErrorList(ex.getBindingResult(), status);

		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessExeption(EmptyResultDataAccessException exception,
			WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = makeSourceMessage("resource.not-found");
		String cause = exception.getCause() != null ? exception.getCause().toString() : exception.toString();
		List<ErrorMessage> responseBody = makeResponseBody(message, cause, status);

		return handleExceptionInternal(exception, responseBody, new HttpHeaders(), status, request);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception,
			WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = makeSourceMessage("resource.operation-not-allowed");
		String cause = ExceptionUtils.getRootCauseMessage(exception);
		List<ErrorMessage> responseBody = makeResponseBody(message, cause, status);

		return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception,
			WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = makeSourceMessage("constraint.violation");
		String cause = exception.getCause() != null ? exception.getCause().toString() : exception.toString();
		List<ErrorMessage> responseBody = makeResponseBody(message, cause, status);

		return handleExceptionInternal(exception, responseBody, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
			WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = makeSourceMessage("illegal.argument");
		String cause = exception.getCause() != null ? exception.getCause().toString() : exception.toString();
		List<ErrorMessage> responseBody = makeResponseBody(message, cause, status);
		
		return handleExceptionInternal(exception, responseBody, new HttpHeaders(), status, request);
	}

}
