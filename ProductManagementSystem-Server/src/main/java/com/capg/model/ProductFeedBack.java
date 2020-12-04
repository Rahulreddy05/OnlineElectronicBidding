package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="productfeedback")
public class ProductFeedBack {

	@Id
	private int productFeedbackId;
	private int productId;
	private int userId;
	private double rating;
	private String feedback;
	public int getProductFeedbackId() {
		return productFeedbackId;
	}
	public void setProductFeedbackId(int productFeedbackId) {
		this.productFeedbackId = productFeedbackId;
	}
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "ProductFeedBack [productFeedbackId=" + productFeedbackId + ", productId=" + productId + ", userId="
				+ userId + ", rating=" + rating + ", feedback=" + feedback + "]";
	}
	
}
