package com.microservice.tuto.app.user.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tuto.app.user.dto.LoginDTO;
import com.microservice.tuto.app.user.entities.User;
import com.microservice.tuto.app.user.interfaces.IAuthenticationService;
import com.microservice.tuto.app.user.interfaces.IController;
import com.microservice.tuto.app.user.interfaces.ICrudService;

@RestController
@RequestMapping("/api/users")
public class UserController implements IController<User> {

	@Autowired
	private ICrudService<User> iCrudService;

	@Autowired
	private IAuthenticationService iAuthenticationService;

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(iCrudService.findAll());
	}

	@Override
	public ResponseEntity<User> save(@Valid User entity) {
		return new ResponseEntity<>(iCrudService.save(entity), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok(iCrudService.findById(id));
	}

	@Override
	public ResponseEntity<Void> update(long id, @Valid User entity) {
		iCrudService.update(entity, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> delete(long id) {
		iCrudService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> signInEmail(@Valid LoginDTO loginDTO) {
		return ResponseEntity.ok(iAuthenticationService.loginEmail(loginDTO.getEmail()));
	}

	@Override
	public ResponseEntity<User> signInUserName(@Valid LoginDTO loginDTO) {
		return ResponseEntity.ok(iAuthenticationService.loginUserName(loginDTO.getEmail()));
	}

	@Override
	public ResponseEntity<User> signUserNameOrEmaail(@Valid LoginDTO loginDTO) {
		return ResponseEntity.ok(iAuthenticationService.loginUserNameOrEmail(loginDTO.getEmail()));
	}

}
