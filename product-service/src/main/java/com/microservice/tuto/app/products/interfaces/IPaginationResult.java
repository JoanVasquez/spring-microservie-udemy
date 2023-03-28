package com.microservice.tuto.app.products.interfaces;

import com.microservice.tuto.app.products.dto.PaginatedResult;

public interface IPaginationResult<Entity> {
	public PaginatedResult<Entity> paginatedResult(int numberOfPages, int qtyPerPage, String orderBy, String sortBy);
}
