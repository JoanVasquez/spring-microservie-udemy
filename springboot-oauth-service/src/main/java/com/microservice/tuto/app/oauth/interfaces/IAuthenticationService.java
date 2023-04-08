package com.microservice.tuto.app.oauth.interfaces;

import com.microservice.tuto.app.oauth.entities.User;

public interface IAuthenticationService {

	public User loginEmail(String userName);

	public User loginUserName(String userName);

	public User loginUserNameOrEmail(String userName);

	public boolean existUserByUserName(String userName);

	public boolean existUserByEmail(String email);

}
