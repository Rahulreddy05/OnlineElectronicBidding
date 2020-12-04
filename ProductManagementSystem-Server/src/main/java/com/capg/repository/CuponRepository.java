package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Coupon;

public interface CuponRepository extends JpaRepository<Coupon, String> {

}
