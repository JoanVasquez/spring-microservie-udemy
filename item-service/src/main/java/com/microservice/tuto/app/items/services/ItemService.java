package com.microservice.tuto.app.items.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.tuto.app.items.clients.IProductClientRest;
import com.microservice.tuto.app.items.entities.Item;
import com.microservice.tuto.app.items.interfaces.IReadService;

@Service
public class ItemService implements IReadService<Item> {

	@Autowired
	private IProductClientRest iProductClientRest;

	@Override
	public List<Item> findAll() {
		return iProductClientRest.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(long id, Integer quantity) {
		return new Item(iProductClientRest.detail(id), quantity);
	}

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Override
//	public List<Item> findAll() {
//		List<Product> products = Arrays
//				.asList(restTemplate.getForObject("http:product-service/api/products", Product[].class));
//		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
//	}
//
//	@Override
//	public Item findById(long id, Integer quantity) {
//		Product product = restTemplate.getForObject("http:product-service/api/products/{id}", Product.class, id);
//		return new Item(product, quantity);
//	}

}
