package com.microservice.tuto.app.items.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface IController<Entity> {

	@HystrixCommand(fallbackMethod = "findAllFromLocal")
	@PostMapping("/findall")
	public ResponseEntity<List<Entity>> findAll();

	@HystrixCommand(fallbackMethod = "findByIdFromLocal")
	@GetMapping("/{id}/quantity/{quantity}")
	public ResponseEntity<Entity> findById(@PathVariable(name = "id") Long id,
			@PathVariable(name = "quantity") Integer quantity);
}
