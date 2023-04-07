package com.microservice.tuto.app.user.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.tuto.app.user.dto.LoginDTO;

public interface IController<Entity> {

	@GetMapping("/findall")
	public ResponseEntity<List<Entity>> findAll();

	@PostMapping
	public ResponseEntity<Entity> save(@Valid @RequestBody Entity entity);

	@GetMapping("/{id}")
	public ResponseEntity<Entity> findById(@PathVariable(name = "id") Long id);

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") long id, @Valid @RequestBody Entity entity);

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id);
	
	@GetMapping("/email/signin")
	public ResponseEntity<Entity> signInEmail(@Valid @RequestBody LoginDTO loginDTO);
	
	@GetMapping("/username/signin")
	public ResponseEntity<Entity> signInUserName(@Valid @RequestBody LoginDTO loginDTO);

	@GetMapping("/username/or/email/signin")
	public ResponseEntity<Entity> signUserNameOrEmaail(@Valid @RequestBody LoginDTO loginDTO);
}
