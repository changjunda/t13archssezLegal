package com.ncs.iss.ezlegal.rating.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserRatingDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forUserId")
	private String forUserId;
	
	@JsonProperty("byUserId")
	private String byUserId;

	public DeleteUserRatingDTO() {
		super();
	}

	public DeleteUserRatingDTO(String forUserId, String byUserId) {
		super();
		this.forUserId = forUserId;
		this.byUserId = byUserId;
	}

	public String getForUserId() {
		return forUserId;
	}

	public void setForUserId(String forUserId) {
		this.forUserId = forUserId;
	}

	public String getByUserId() {
		return byUserId;
	}

	public void setByUserId(String byUserId) {
		this.byUserId = byUserId;
	}

}
