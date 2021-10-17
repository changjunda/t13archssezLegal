package com.ncs.iss.ezlegal.rating.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserRatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forUserId")
	private String forUserId;

	@JsonProperty("byUserId")
	private String byUserId;

	@JsonProperty("rating")
	private String rating;

	@JsonProperty("averageRating")
	private String averageRating;
	
	public AddUserRatingResponseDTO() {
		super();
	}

	public AddUserRatingResponseDTO(String forUserId, String byUserId, String rating, String averageRating) {
		super();
		this.forUserId = forUserId;
		this.byUserId = byUserId;
		this.rating = rating;
		this.averageRating = averageRating;
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

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

}
