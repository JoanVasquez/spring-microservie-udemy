package com.microservice.tuto.app.products.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResult<Entity> {

	private List<Entity> content;
	private int pageNumber;
	private int qtyPerPage;
	private long totalItems;
	private int totalPages;
	private boolean isFirstPage;
	private boolean isLastPage;
	
}
