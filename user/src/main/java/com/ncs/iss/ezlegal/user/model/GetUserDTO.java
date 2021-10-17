package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	public GetUserDTO() {
		super();
	}

	public GetUserDTO(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
