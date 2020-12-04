package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	


}
