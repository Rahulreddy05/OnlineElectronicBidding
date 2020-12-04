package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Product_master")
public class Product {

	@Id
	private int productId;
	private int userId;
	private String productName;
	enum Type{
		FASHION,SPORTS,ELECTRONICS,HOME_APPLIANCES;
	};
	private Type productType;
	private String productDescription;
	//Add image 
	//private 
	private double productPrice;
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	private double averageRating;
	private int discount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Type getProductType() {
		return productType;
	}
	public void setProductType(Type productType) {
		this.productType = productType;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", userId=" + userId + ", productName=" + productName
				+ ", productType=" + productType + ", productDescription=" + productDescription + ", productPrice="
				+ productPrice + ", averageRating=" + averageRating + ", discount=" + discount + "]";
	}
	
	
}
