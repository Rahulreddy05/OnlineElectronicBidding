package com.capg.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Confirmation {

	@Id
	@Column(name="token_id")
	private long tokenId;
	@Column(name="confirmation_token")
	private String confirmationToken;
	
	@OneToOne(targetEntity = Users.class , fetch = FetchType.EAGER)
	@JoinColumn(nullable = false , name = "user_id")
	private Users user;
	
	public Confirmation() {
		
	}
	
	public Confirmation(Users user)
	{
		this.user=user;
		tokenId=(long)(Math.random()*1000);
		confirmationToken = UUID.randomUUID().toString();
	}

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Confirmation [tokenId=" + tokenId + ", confirmationToken=" + confirmationToken + ", user=" + user + "]";
	}
	
}
