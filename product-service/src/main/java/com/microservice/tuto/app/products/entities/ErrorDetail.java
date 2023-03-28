package com.microservice.tuto.app.products.entities;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDetail {

	private Date markOfTime;
	private String message;
	private String details;

}
