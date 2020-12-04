package com.capg.controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import com.capg.model.ImageModel;
import com.capg.model.Products;
import com.capg.model.Transactions;
import com.capg.model.Users;
import com.capg.service.EmailSenderService;
import com.capg.service.IProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductManagementContoller {
	
	   
	@Autowired
	IProductService service;
	
	@Autowired
	private EmailSenderService emailService;
	
	Users users=new Users();
	
	@GetMapping(path = "", produces = "application/json")
	@ResponseBody
	public Transactions generateInvoice() {
		
		return null;
		
	}

	    
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	
	@PostMapping(path="/imageUpload")
	public String uploadImage(@RequestParam("imageFile") MultipartFile fileToUpload) throws IOException
	{
	    System.out.println(fileToUpload);
		System.out.println("hello");
		ImageModel img = new ImageModel( fileToUpload.getOriginalFilename(), fileToUpload.getContentType(),
				compressBytes(fileToUpload.getBytes()));
		String x=service.imageUpload(img);
		System.out.println(x);
		return "SuccessFully Uploaded";
		
	}
	
	@GetMapping(path="/getImages")
	public ArrayList<ImageModel> getImages()
	{
		ArrayList<ImageModel> cim=new ArrayList<ImageModel>();
		ArrayList<ImageModel> ucim=new ArrayList<ImageModel>();
		cim=service.getImage();
		for(ImageModel i: cim)
		{
			ImageModel img=new ImageModel(i.getId(),i.getName(), i.getType(),
					decompressBytes(i.getPicByte()));
			ucim.add(img);
			
		}
		System.out.println(ucim.get(2));
		return ucim;
	}
	
	@PostMapping(path="/register")
	public Users registerUser(@RequestBody Users user) {
		return service.registerUser(user);
	}
	@PostMapping(path="/addProduct")
	public Products addProduct(@RequestBody Products product)
	{
		
		return service.addProduct(product);
	}
	
	@GetMapping(path="/getUser/{email}/{password}")
	public Users getUser(@PathVariable String email,@PathVariable String password) {
		 Users user=service.getUser(email);
		 Users receiveUser=null;
		 if(user!=null) {
		 if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
			 receiveUser=user;
		 }else  
		 {
			 receiveUser=null;
		 }}
		 return receiveUser;
		 
	}
	
	@GetMapping(path="/forgotpassword/{email}")
	public boolean forgotPassword(@PathVariable String email) {
		users = service.forgotPassword(email);
		boolean sentMail=false;
		if(users != null)
		{
			emailService.createEmailMessage(users.getEmail());
			emailService.sendEmail();
			sentMail=true;
		}else if(users==null) {
			sentMail=false;
		}
		
		return sentMail;
	}
	
	@GetMapping(path="/resetpassword/{nPassword}/{cPassword}")
	public boolean changePassword(@PathVariable String nPassword,@PathVariable String cPassword) {
		
		String email=users.getEmail();
		boolean changed;
		Users user=service.changePassword(nPassword,cPassword,email);
		if(user!=null) {
			changed=true;
		}else
		{
			changed=false;
		}
		return changed;
	}
	
	
	@GetMapping(path="/getProducts")
	public ArrayList getProducts()
	{
		ArrayList al=new ArrayList();
		
		al= service.getProducts();
		//getImages();
		return al;
		
		
	}
	
	 @RequestMapping(value="register/{token}", method= {RequestMethod.GET, RequestMethod.POST})
	 public ModelAndView confirmUserAccount(@PathVariable String token)
     {
		 service.confirmUserAccount(token);
		 String url = "http://localhost:4200/";
		 return new ModelAndView("redirect:"+url);
     }
	
}
