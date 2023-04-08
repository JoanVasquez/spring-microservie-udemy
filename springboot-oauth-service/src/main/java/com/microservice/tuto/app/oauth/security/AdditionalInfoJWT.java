package com.microservice.tuto.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.microservice.tuto.app.oauth.entities.User;
import com.microservice.tuto.app.oauth.interfaces.IAuthenticationService;

@Component
public class AdditionalInfoJWT implements TokenEnhancer {

	@Autowired
	private IAuthenticationService iAuthenticationService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();

		User user = iAuthenticationService.loginUserName(authentication.getName());
		info.put("firstName", user.getName());
		info.put("lastName", user.getLastName());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		return accessToken;
	}

}
