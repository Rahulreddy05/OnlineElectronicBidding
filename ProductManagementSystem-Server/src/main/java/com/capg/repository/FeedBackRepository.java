package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.FeedbackCommon;

public interface FeedBackRepository extends JpaRepository<FeedbackCommon,Integer> {

}
