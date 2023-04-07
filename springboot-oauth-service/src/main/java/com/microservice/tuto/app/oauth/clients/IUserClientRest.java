package com.microservice.tuto.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.tuto.app.oauth.dto.LoginDTO;
import com.microservice.tuto.app.oauth.entities.User;

@FeignClient(name = "user-service")
public interface IUserClientRest {

	@PostMapping("/api/user/signin")
	public User signIn(LoginDTO loginDTO);

}
