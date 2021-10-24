package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListDocumentDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("userId")
	private int userId;
	
	public ListDocumentDTO() {
		super();
	}
	
	public ListDocumentDTO(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
