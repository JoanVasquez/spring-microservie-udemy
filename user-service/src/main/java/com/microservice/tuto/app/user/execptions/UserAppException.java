package com.microservice.tuto.app.user.execptions;

import org.apache.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAppException extends RuntimeException {

	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	private String message;

	public UserAppException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
