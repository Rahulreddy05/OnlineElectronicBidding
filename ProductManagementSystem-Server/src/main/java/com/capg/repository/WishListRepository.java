package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer> {

}
