package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {

}
