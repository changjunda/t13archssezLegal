package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserEmailResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("exist")
	private String exist;
	
	public GetUserEmailResponseDTO() {
		super();
	}

	public GetUserEmailResponseDTO(String exist) {
		super();
		this.exist = exist;
	}

	public String getExist() {
		return exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

}
