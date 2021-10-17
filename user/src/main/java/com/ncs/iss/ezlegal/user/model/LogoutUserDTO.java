package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogoutUserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("sessionId")
	private String sessionId;
	
	public LogoutUserDTO() {
		super();
	}

	public LogoutUserDTO(String userId, String sessionId) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
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

}
