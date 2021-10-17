package com.ncs.iss.ezlegal.rating.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserRatingDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forUserId")
	private String forUserId;
	
	@JsonProperty("byUserId")
	private String byUserId;

	@JsonProperty("rating")
	private String rating;

	public AddUserRatingDTO() {
		super();
	}

	public AddUserRatingDTO(String forUserId, String byUserId, String rating) {
		super();
		this.forUserId = forUserId;
		this.byUserId = byUserId;
		this.rating = rating;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
