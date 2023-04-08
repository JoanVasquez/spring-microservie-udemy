package com.microservice.tuto.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.tuto.app.oauth.dto.LoginDTO;
import com.microservice.tuto.app.oauth.entities.User;

@FeignClient(name = "user-service")
public interface IUserClientRest {

	@PostMapping("/api/user/email/signin")
	public User loginInEmail(String userName);

	@PostMapping("/api/user/username/signin")
	public User loginInUserName(String userName);

	@PostMapping("/api/user/username/or/email/signin")
	public User loginUserNameOrEmail(String userName);

}
