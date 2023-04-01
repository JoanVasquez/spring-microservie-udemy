package com.microservice.tuto.app.items.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tuto.app.items.entities.Item;
import com.microservice.tuto.app.items.interfaces.IController;
import com.microservice.tuto.app.items.interfaces.IReadService;
import com.netflix.discovery.converters.Auto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api/items")
public class ItemController implements IController<Item> {

	@Autowired
	private IReadService<Item> iReadService;

	@Autowired
	private CircuitBreakerFactory cbBreakerFactory;

	@Override
	public ResponseEntity<List<Item>> findAll() {
		return ResponseEntity.ok(this.iReadService.findAll());
	}

	@Override
	public ResponseEntity<Item> findById(Long id, Integer quantity) {
		return cbBreakerFactory.create("item").run(() -> ResponseEntity.ok(this.iReadService.findById(id, quantity)),
				e -> findByIdFromLocal(id, quantity, e));
	}
	
	@GetMapping("/test2/{id}/quantity/{quantity}")
	@CircuitBreaker(name = "items", fallbackMethod = "findByIdFromLocal")
	public ResponseEntity<Item> findByIdTwo(Long id, Integer quantity) {
		return ResponseEntity.ok(this.iReadService.findById(id, quantity));
	}
	
	@GetMapping("/test3/{id}/quantity/{quantity}")
	@TimeLimiter(name = "items", fallbackMethod = "findByIdFromLocal")
	@CircuitBreaker(name = "items")
	public CompletableFuture<Item> findByIdThree(Long id, Integer quantity) {
		return CompletableFuture.supplyAsync(() -> this.iReadService.findById(id, quantity));
	}

	public List<Item> findAllFromLocal() {
		return null;
	}

	public ResponseEntity<Item> findByIdFromLocal(Long id, Integer qty, Throwable e) {
		return null;
	}

}
