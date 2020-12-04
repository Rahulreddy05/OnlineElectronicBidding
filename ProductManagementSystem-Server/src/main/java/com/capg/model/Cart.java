package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cart {

	@Id
	private int cartId;
	private int productId;
	private int userId;
	private double totalCost;
	private enum Status{
		ACTIVE,NOT_ACTIVE;
	};
	private Status status;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + ", totalCost=" + totalCost
				+ ", status=" + status + ", getCartId()=" + getCartId() + ", getProductId()=" + getProductId()
				+ ", getUserId()=" + getUserId() + ", getTotalCost()=" + getTotalCost() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
