package com.microservice.tuto.app.items.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private Long id;
	private String name;
	private Double price;
	private Date createdAt;
	
}
