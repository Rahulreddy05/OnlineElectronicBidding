package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Confirmation;

public interface ConfirmationRepository extends JpaRepository<Confirmation	, Integer> {

	Confirmation findByConfirmationToken(String token);

}
