package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
