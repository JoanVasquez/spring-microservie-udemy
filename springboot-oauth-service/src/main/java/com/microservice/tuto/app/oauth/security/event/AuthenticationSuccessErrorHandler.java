package com.microservice.tuto.app.oauth.security.event;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
//		if(authentication.getName().equalsIgnoreCase("frontendapp")) {
//			
//		}
		
		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("Success login: ==> " + userDetails.getUsername());
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("Error login: ==> " + userDetails.getUsername());
	}

}
