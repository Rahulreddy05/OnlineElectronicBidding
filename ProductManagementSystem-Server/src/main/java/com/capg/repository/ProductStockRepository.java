package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.ProductStock;

public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {

}
