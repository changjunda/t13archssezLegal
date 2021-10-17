package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserEmailDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("email")
	private String email;
	
	public GetUserEmailDTO() {
		super();
	}

	public GetUserEmailDTO(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
