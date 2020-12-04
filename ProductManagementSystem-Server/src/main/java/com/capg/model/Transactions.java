package com.capg.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Transactions {

	@Id
	private int transactionId;
	private int userId;
	private double totalCost;
	private Date dateOfTransaction;
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	private double couponDiscount;
	private double discountedTotalCost;
	private Date transactionDate;
	private Date dateOfDelivery;
	private String address;
	private enum StatusOfDelivery{
		DELIVERED,IN_TRANSIT,SHIPPED,ORDER_CONFIRMED,RETURNED
	};
	private StatusOfDelivery statusofDelivery;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public StatusOfDelivery getStatusofDelivery() {
		return statusofDelivery;
	}
	public void setStatusofDelivery(StatusOfDelivery statusofDelivery) {
		this.statusofDelivery = statusofDelivery;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	
	  public Cart getCart() { return cart; } public void setCart(Cart cart) {
	  this.cart = cart; }
	 
	public double getCouponDiscount() {
		return couponDiscount;
	}
	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", userId=" + userId + ", totalCost=" + totalCost
				+ ", dateOfTransaction=" + dateOfTransaction + ", couponDiscount=" + couponDiscount
				+ ", transactionDate=" + transactionDate + ", dateOfDelivery=" + dateOfDelivery + "]";
	}
	
	
	
}
