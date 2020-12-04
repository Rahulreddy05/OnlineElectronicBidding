package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Coupon_master")
public class Coupon {

	@Id
	private String couponCode;
	private double discountAmount;
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	@Override
	public String toString() {
		return "Coupon [couponCode=" + couponCode + ", discountAmount=" + discountAmount + "]";
	}
	
}
