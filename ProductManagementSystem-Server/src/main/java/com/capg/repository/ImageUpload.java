package com.capg.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.model.ImageModel;

public interface ImageUpload extends JpaRepository<ImageModel,Integer> {
	
	 ImageModel findByName(String Name);
	 
	 @Query(value="select * from ImageModel",nativeQuery = true)
	 ArrayList<ImageModel> getProducts();

}
