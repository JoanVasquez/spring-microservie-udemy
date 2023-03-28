package com.microservice.tuto.app.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tuto.app.products.dto.PaginatedResult;
import com.microservice.tuto.app.products.entities.Product;
import com.microservice.tuto.app.products.interfaces.IController;
import com.microservice.tuto.app.products.interfaces.ICrudService;

@RestController
@RequestMapping("/api/products")
public class ProductController implements IController<Product> {
	
	@Autowired
	private ICrudService<Product> iCrudService;

	@Override
	public ResponseEntity<PaginatedResult<Product>> findAllPaginated(int numeroDePagina, int medidaDePagina,
			String ordenarPor, String sortDir) {
		return ResponseEntity.ok(iCrudService.paginatedResult(numeroDePagina, medidaDePagina, ordenarPor, sortDir));
	}

	@Override
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(iCrudService.findAll());
	}

	@Override
	public ResponseEntity<Product> save(@Valid Product entity) {
		return new ResponseEntity<>(iCrudService.save(entity), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Product> findById(Long id) {
		return ResponseEntity.ok(iCrudService.findById(id));
	}

	@Override
	public ResponseEntity<Void> update(long id, @Valid Product entity) {
		iCrudService.update(entity, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> delete(long id) {
		iCrudService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
