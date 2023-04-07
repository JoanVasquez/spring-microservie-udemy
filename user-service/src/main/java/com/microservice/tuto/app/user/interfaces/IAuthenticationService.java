package com.microservice.tuto.app.user.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.microservice.tuto.app.user.entities.User;

public interface IAuthenticationService {

	@Transactional(readOnly = true)
	public User loginEmail(String email);

	@Transactional(readOnly = true)
	public User loginUserName(String userName);
	
	@Transactional(readOnly = true)
	public User loginUserNameOrEmail(String userNameOrEmail);

	@Transactional(readOnly = true)
	public boolean existUserByUserName(String userName);

	@Transactional(readOnly = true)
	public boolean existUserByEmail(String email);

}
