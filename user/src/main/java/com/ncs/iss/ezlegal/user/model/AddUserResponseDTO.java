package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("role")
	private String role;
	
	public AddUserResponseDTO() {
		super();
	}

	public AddUserResponseDTO(String userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
