package com.microservice.tuto.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.tuto.app.items.entities.Product;

@FeignClient(name = "product-service")
public interface IProductClientRest {

	@GetMapping("/api/products")
	public List<Product> findAll();

	@GetMapping("/api/products/{id}")
	public Product detail(@PathVariable Long id);

	@PostMapping("/api/products")
	public Product save(@RequestBody Product product);

	@PutMapping("/api/products/{id}")
	public void update(@RequestBody Product product, @PathVariable Long id);
	
	@DeleteMapping("/api/products/{id}")
	public void delete(@PathVariable Long id);
	
	
}
