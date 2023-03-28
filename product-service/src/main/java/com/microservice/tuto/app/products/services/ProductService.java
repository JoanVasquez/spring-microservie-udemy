package com.microservice.tuto.app.products.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.microservice.tuto.app.products.dto.PaginatedResult;
import com.microservice.tuto.app.products.entities.Product;
import com.microservice.tuto.app.products.exceptions.ResourceNotFoundException;
import com.microservice.tuto.app.products.interfaces.ICrudService;
import com.microservice.tuto.app.products.interfaces.IProductRepository;

@Service
public class ProductService implements ICrudService<Product> {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public PaginatedResult<Product> paginatedResult(int numberOfPages, int qtyPerPage, String orderBy, String sortBy) {

		Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
				: Sort.by(orderBy).descending();
		Pageable pageable = PageRequest.of(numberOfPages, qtyPerPage, sort);
		Page<Product> productsPage = productRepository.findAll(pageable);
		List<Product> products = productsPage.getContent();

		PaginatedResult<Product> productResult = new PaginatedResult<>();
		productResult.setContent(products);
		productResult.setFirstPage(productsPage.isFirst());
		productResult.setLastPage(productsPage.isLast());
		productResult.setPageNumber(productsPage.getNumber());
		productResult.setQtyPerPage(productsPage.getSize());
		productResult.setTotalItems(productsPage.getTotalElements());
		productResult.setTotalPages(productsPage.getTotalPages());

		return productResult;
	}

	@Override
	public Product save(Product entity) {
		entity.setCreatedAt(new Date());
		return productRepository.save(entity);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}

	@Override
	public void update(Product entity, long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

		product.setName(entity.getName());
		product.setPrice(entity.getPrice());
		productRepository.save(product);
	}

	@Override
	public void delete(long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepository.delete(product);

	}

}
