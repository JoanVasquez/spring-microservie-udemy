package com.microservice.tuto.app.oauth.interfaces;

import com.microservice.tuto.app.oauth.entities.User;

public interface IAuthenticationService {

	public User loginEmail(String email, String pass);

	public User loginUserName(String email, String pass);

	public boolean existUserByUserName(String userName);

	public boolean existUserByEmail(String email);

}
