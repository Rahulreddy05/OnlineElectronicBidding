package com.capg.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.model.Confirmation;
import com.capg.model.ImageModel;
import com.capg.model.Products;
import com.capg.model.Transactions;
import com.capg.model.Users;
import com.capg.repository.ConfirmationRepository;
import com.capg.repository.ImageUpload;
import com.capg.repository.ProductsRepository;
import com.capg.repository.UsersRepository;
import com.capg.service.EmailSenderService;

@Repository
public class ProductDaoImp implements IProductDao {

	@Autowired 
	Transactions transaction;
	
	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	ConfirmationRepository conRepo;
	
	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	ProductsRepository productrepo;
	
	@Autowired
	ImageUpload imageUploadRepo;
	
	@Override
	public Transactions generateInvoice() {
		
		return null;
		
	}
	

	@Override
	public Users registerUser(Users user) {
		// TODO Auto-generated method stub
		
		Users existingUser= userRepo.findByEmail(user.getEmail());
		if(existingUser==null)
		{
			user.setDateOfCreation(new Date());
			user.setUserId((int)(Math.random()*10000));
			userRepo.save(user);
			Confirmation token = new Confirmation(user);
			System.out.println(token);
			conRepo.save(token);
			emailService.createEmailMessage(user,token.getConfirmationToken());
			emailService.sendEmail();
			return user;
		}else {
			user= null;
		}
		return user;
	
	}

	@Override
	public Users forgotPassword(String email) {
		// TODO Auto-generated method stub
		Users user=userRepo.findByEmail(email);
		return user;
	}

	@Override
	public Users confirmationToken(String token) {
		// TODO Auto-generated method stub
		Confirmation conToken = conRepo.findByConfirmationToken(token);

	     if(conToken != null)
	     {
	         Users user = userRepo.findByEmail(conToken.getUser().getEmail());
	         user.setActive(true);
	         userRepo.save(user);
	        return user;
	     }
	     else
	     {
	         return null;
	     }
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		Users existingUser= userRepo.findByEmail(email);
		if(existingUser==null)
		{
			existingUser=null;
		}
		return existingUser;
	}

	@Override
	public Users changePassword(String nPassword, String cPassword, String email) {
		// TODO Auto-generated method stub
		int eq=nPassword.compareTo(cPassword);
		Users existingUser;
		Users receiveUser = null;
		if(eq==0) {
		existingUser= userRepo.findByEmail(email);
		if(existingUser!=null)
		{
			existingUser.setPassword(nPassword);
			receiveUser=userRepo.save(existingUser);
		}else
		{
			receiveUser=null;
		}
		}
		return receiveUser;
	}
	
	ImageModel img;


	@Override
	public String imageUpload(ImageModel imge) {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		img=imge;
		
		imageUploadRepo.save(img);
		
		return "SuccessFully Uploaded";
	}


	@Override
	public Products addProducts(Products product) {
		// TODO Auto-generated method stub
		product=new Products(img,product);
		product.setProductId((Math.random()*10000));
		
		System.out.println(product);
		productrepo.save(product);
		System.out.println("done");
		//getProducts();
		return product;
	}


	@Override
	public ArrayList getProducts() {
		// TODO Auto-generated method stub
		ArrayList<Products> al=new ArrayList();
		al=productrepo.getProducts();
		//System.out.println(al);
		getImage();
		return al;
	}


	@Override
	public ArrayList getImage() {
		// TODO Auto-generated method stub
		ArrayList<ImageModel> im=new ArrayList();
		im=imageUploadRepo.getProducts();
		//System.out.println(im);
		return im;
	}

}
