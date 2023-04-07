package com.microservice.tuto.app.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

	private String userName;
	private String email;
	private String pass;

}
