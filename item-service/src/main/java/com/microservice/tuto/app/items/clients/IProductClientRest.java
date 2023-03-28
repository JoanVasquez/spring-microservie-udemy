package com.microservice.tuto.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.tuto.app.items.entities.Product;

@FeignClient(name = "product-service")
public interface IProductClientRest {

	@GetMapping("/api/products")
	public List<Product> findAll();

	@GetMapping("/api/products/{id}")
	public Product detail(@PathVariable Long id);
}
