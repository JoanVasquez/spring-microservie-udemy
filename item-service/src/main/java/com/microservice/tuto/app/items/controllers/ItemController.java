package com.microservice.tuto.app.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tuto.app.items.entities.Item;
import com.microservice.tuto.app.items.interfaces.IController;
import com.microservice.tuto.app.items.interfaces.IReadService;

@RestController
@RequestMapping("/api/items")
public class ItemController implements IController<Item> {

	@Autowired
	private IReadService<Item> iReadService;

	@Override
	public ResponseEntity<List<Item>> findAll() {
		return ResponseEntity.ok(this.iReadService.findAll());
	}

	@Override
	public ResponseEntity<Item> findById(Long id, Integer quantity) {
		return ResponseEntity.ok(this.iReadService.findById(id, quantity));
	}
	
	public List<Item> findAllFromLocal() {
		return null;
	}
	
	public Item findByIdFromLocal(Long id) {
		return null;
	}

}
