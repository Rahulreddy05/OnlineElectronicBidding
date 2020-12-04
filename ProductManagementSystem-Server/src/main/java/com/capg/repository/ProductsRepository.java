package com.capg.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.model.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {

	Optional<Products> findById(String name);
	
	@Query(value="select * from products p",nativeQuery = true)
	ArrayList<Products> getProducts();
}
