package com.microservice.tuto.app.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.tuto.app.user.entities.User;
import com.microservice.tuto.app.user.execptions.ResourceNotFoundException;
import com.microservice.tuto.app.user.interfaces.IAuthenticationService;
import com.microservice.tuto.app.user.interfaces.ICrudService;
import com.microservice.tuto.app.user.interfaces.IUserRepository;

@Service
public class UserServicer implements ICrudService<User>, IAuthenticationService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User save(User entity) {
		return this.userRepository.save(entity);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", Long.toString(id)));
	}

	@Override
	public void update(User entity, long id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", Long.toString(id)));

		user.setEmail(entity.getEmail());
		user.setEnabled(entity.isEnabled());
		user.setLastName(entity.getLastName());
		user.setName(entity.getName());
		user.setPassword(entity.getPassword());
		user.setRoles(entity.getRoles());
		user.setUsername(entity.getUsername());

		this.userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", Long.toString(id)));
		this.userRepository.delete(user);
	}

	@Override
	public boolean existUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existUserByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loginEmail(String email) {
		return this.userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
	}

	@Override
	public User loginUserName(String userName) {
		return this.userRepository.findByUserName(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userName", userName));
	}

	@Override
	public User loginUserNameOrEmail(String userNameOrEmail) {
		return this.userRepository.findByUserNameOrEmail(userNameOrEmail)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userNameOrEmail", userNameOrEmail));
	}

}
