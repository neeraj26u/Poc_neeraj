package com.poc.resful.jersey.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Liqui_Detail")
public class LiquiBase {
	
	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "namee")
	private String namee;
	
	@Column(name = "rolee")
	private String rolee;
	
	@Column(name = "password")
	private Long password;
	
	
	public LiquiBase() {}

   
	public LiquiBase(Long userId, String name, String role, Long password) {
		this.userId = userId;
		this.namee = name;
		this.rolee = role;
		this.password = password;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getName() {
		return namee;
	}


	public void setName(String name) {
		this.namee = name;
	}


	public String getRole() {
		return rolee;
	}


	public void setRole(String role) {
		this.rolee = role;
	}


	public Long getPassword() {
		return password;
	}


	public void setPassword(Long password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + namee + ", role=" + rolee + ", password=" + password + "]";
	}

	
}
