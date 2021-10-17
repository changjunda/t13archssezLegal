package com.ncs.iss.ezlegal.rating.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserRatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forUserId")
	private String forUserId;

	@JsonProperty("averageRating")
	private String averageRating;
	
	public GetUserRatingResponseDTO() {
		super();
	}

	public GetUserRatingResponseDTO(String forUserId, String averageRating) {
		super();
		this.forUserId = forUserId;
		this.averageRating = averageRating;
	}

	public String getForUserId() {
		return forUserId;
	}

	public void setForUserId(String forUserId) {
		this.forUserId = forUserId;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}
	
}
