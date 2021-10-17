package com.ncs.iss.ezlegal.rating.post.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePostRatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("postId")
	private String postId;

	@JsonProperty("byUserId")
	private String byUserId;

	@JsonProperty("rating")
	private String rating;

	@JsonProperty("postRating")
	private String postRating;
	
	public UpdatePostRatingResponseDTO() {
		super();
	}

	public UpdatePostRatingResponseDTO(String postId, String byUserId, String rating, String postRating) {
		super();
		this.postId = postId;
		this.byUserId = byUserId;
		this.rating = rating;
		this.postRating = postRating;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
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

	public String getPostRating() {
		return postRating;
	}

	public void setPostRating(String postRating) {
		this.postRating = postRating;
	}
	
}
