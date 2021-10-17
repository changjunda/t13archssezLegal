package com.ncs.iss.ezlegal.rating.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserRatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forUserId")
	private String forUserId;

	@JsonProperty("byUserId")
	private String byUserId;

	@JsonProperty("averageRating")
	private String averageRating;
	
	public DeleteUserRatingResponseDTO() {
		super();
	}

	public DeleteUserRatingResponseDTO(String forUserId, String byUserId, String averageRating) {
		super();
		this.forUserId = forUserId;
		this.byUserId = byUserId;
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

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

}
