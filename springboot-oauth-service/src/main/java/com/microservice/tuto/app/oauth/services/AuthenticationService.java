package com.microservice.tuto.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.tuto.app.oauth.clients.IUserClientRest;
import com.microservice.tuto.app.oauth.dto.LoginDTO;
import com.microservice.tuto.app.oauth.interfaces.IAuthenticationService;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private IUserClientRest iUserClientRest;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.microservice.tuto.app.oauth.entities.User user = iUserClientRest.loginUserNameOrEmail(username);
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

//		if(user == null) {
//			
//		}

		User securityUser = new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), user.isEnabled(), true, true, true, authorities);
		return securityUser;
	}

//	@Override
//	public User loginEmail(LoginDTO loginDTO) {
//		return null;//iUserClientRest.loginInEmail(loginDTO);
//	}
//
//	@Override
//	public User loginUserName(LoginDTO loginDTO) {
//		com.microservice.tuto.app.oauth.entities.User user = iUserClientRest.loginInUserName(loginDTO);
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//		
////		if(user == null) {
////			//throw error
////		}
//		
//		User securityUser = new org.springframework.security.core.userdetails.User(
//				user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
//		return securityUser;
//	}
//
//	@Override
//	public User loginUserNameOrEmail(LoginDTO loginDTO) {
//		return null;//iUserClientRest.loginUserNameOrEmail(loginDTO);
//	}
//
//	@Override
//	public boolean existUserByUserName(String userName) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean existUserByEmail(String email) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
