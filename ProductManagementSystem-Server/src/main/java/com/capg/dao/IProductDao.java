package com.capg.dao;


import java.util.ArrayList;

import com.capg.model.ImageModel;
import com.capg.model.Products;
import com.capg.model.Transactions;
import com.capg.model.Users;

public interface IProductDao {
	
	public Transactions generateInvoice();

	public Users registerUser(Users user);

	public Users forgotPassword(String email);

	public Users confirmationToken(String token);

	public Users getUser(String email);

	public Users changePassword(String nPassword, String cPassword, String email);
	
	public String imageUpload(ImageModel img);

	public Products addProducts(Products product);
	
	public ArrayList getProducts(); 
	
	public ArrayList getImage(); 
	
}
