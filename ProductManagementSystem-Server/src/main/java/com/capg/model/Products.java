package com.capg.model;

import java.io.FileInputStream;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity(name="Products")
public class Products {
	
	private String name;
	@Id
	@Column(name="product_id")
	private Double productId;
	private String discription;
	private String category;
	private double price;
	@Column(name="start_date")
	private Date startDate;
	@OneToOne(targetEntity = ImageModel.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false ,name = "id")
	private ImageModel image;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getProductId() {
		return productId;
	}


	public void setProductId(Double productId) {
		this.productId = productId;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public ImageModel getImage() {
		return image;
	}


	public void setImage(ImageModel imageId) {
		this.image = imageId;
	}

	public Products(ImageModel im,Products p)
	{
		this.image=im;
		this.name = p.getName();
		this.discription = p.getDiscription();
		this.category = p.getCategory();
		this.price = p.getPrice();
		this.startDate = p.getStartDate();
		
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", productId=" + productId + ", discription=" + discription + ", category="
				+ category + ", price=" + price + ", startDate=" + startDate + ", image=" + image + "]";
	}


	public Products(String name, Double productId, String discription, String category, double price, Date startDate,
			ImageModel image) {
		super();
		this.name = name;
		this.productId = productId;
		this.discription = discription;
		this.category = category;
		this.price = price;
		this.startDate = startDate;
		this.image = image;
	}


	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	


}
