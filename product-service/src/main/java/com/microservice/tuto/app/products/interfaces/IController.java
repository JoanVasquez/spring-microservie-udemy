package com.microservice.tuto.app.products.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.tuto.app.products.dto.PaginatedResult;
import com.microservice.tuto.app.products.utils.AppConstant;

public interface IController<Entity> {

	@GetMapping("/paginated")
	public ResponseEntity<PaginatedResult<Entity>> findAllPaginated(
			@RequestParam(value = "pageNo", defaultValue = AppConstant.DEFAULT_NUMBER_OF_PAGES, required = false) int numeroDePagina,
			@RequestParam(value = "pageSize", defaultValue = AppConstant.DEFAULT_QTY_PER_PAGE, required = false) int medidaDePagina,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.DEFAULT_ORDER_BY_DEFAULT, required = false) String ordenarPor,
			@RequestParam(value = "sortDir", defaultValue = AppConstant.DEFAULT_ORDER_DIRECTION, required = false) String sortDir);

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
}
