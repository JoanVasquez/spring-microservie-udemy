package com.microservice.tuto.app.oauth.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Long id;
	private String name;
	private String lastName;
	private boolean enabled;
	private String email;
	private String password;
	private List<Role> roles;

}
