package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="feedbackcommon")
public class FeedbackCommon {

	@Id
	private int feedbackId;
	private String feedbackMerchant;
	private int userId;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackMerchant() {
		return feedbackMerchant;
	}
	public void setFeedbackMerchant(String feedbackMerchant) {
		this.feedbackMerchant = feedbackMerchant;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "FeedbackCommon [feedbackId=" + feedbackId + ", feedbackMerchant=" + feedbackMerchant + ", userId="
				+ userId + "]";
	}
	
}
