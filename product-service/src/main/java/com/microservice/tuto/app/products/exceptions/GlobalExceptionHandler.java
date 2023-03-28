package com.microservice.tuto.app.products.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.tuto.app.products.entities.ErrorDetail;

@ControllerAdvice(basePackages = "com.microservice.tuto.app.products")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleResourceNotFound(Exception exception, WebRequest webRequest) {
		ErrorDetail errorDetail = createError(exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ProductAppException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ErrorDetail> handleProductAppExeception(Exception exception, WebRequest webRequest) {
		ErrorDetail errorDetail = createError(exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleGlobalException(Exception exception, WebRequest webRequest) {
		ErrorDetail errorDetail = createError(exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	private ErrorDetail createError(String message, String details) {
		return ErrorDetail.builder().markOfTime(new Date()).message(message).details(details).build();
	}

	protected ResponseEntity<Object> handleMethodArgumentsNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			errores.put(fieldName, message);
		});

		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
}
