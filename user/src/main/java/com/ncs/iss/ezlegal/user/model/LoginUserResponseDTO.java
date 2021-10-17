package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("sessionId")
	private String sessionId;
	
	@JsonProperty("role")
	private String role;
	
	public LoginUserResponseDTO() {
		super();
	}

	public LoginUserResponseDTO(String userId, String sessionId, String role) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
