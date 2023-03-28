package com.microservice.tuto.app.products.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.tuto.app.products.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
