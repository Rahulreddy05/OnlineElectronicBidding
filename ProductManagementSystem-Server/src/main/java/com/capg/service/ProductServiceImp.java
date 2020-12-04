package com.capg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IProductDao;
import com.capg.model.ImageModel;
import com.capg.model.Products;
import com.capg.model.Transactions;
import com.capg.model.Users;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductDao dao;
	@Override
	public Transactions generateInvoice() {
		return null;
	}

	@Override
	public Users registerUser(Users user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public Users forgotPassword(String email) {
		// TODO Auto-generated method stub
		return dao.forgotPassword(email);
	}

	@Override
	public Users confirmUserAccount(String token) {
		// TODO Auto-generated method stub
		return dao.confirmationToken(token);
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return dao.getUser(email);
	}

	@Override
	public Users changePassword(String nPassword, String cPassword, String email) {
		// TODO Auto-generated method stub
		return dao.changePassword(nPassword,cPassword,email);
	}

	@Override
	public String imageUpload(ImageModel img) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String x=dao.imageUpload(img);
		System.out.println(x);
		return x;
	}

	@Override
	public Products addProduct(Products product) {
		// TODO Auto-generated method stub
		return dao.addProducts(product);
	}

	

	@Override
	public ArrayList getProducts() {
		// TODO Auto-generated method stub
		return dao.getProducts();
	}

	@Override
	public ArrayList getImage() {
		// TODO Auto-generated method stub
		return dao.getImage();
	}

}
