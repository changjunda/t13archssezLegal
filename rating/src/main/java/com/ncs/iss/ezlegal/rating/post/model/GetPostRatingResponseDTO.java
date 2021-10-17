package com.ncs.iss.ezlegal.rating.post.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPostRatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("postId")
	private String postId;

	@JsonProperty("postRating")
	private String postRating;
	
	public GetPostRatingResponseDTO() {
		super();
	}

	public GetPostRatingResponseDTO(String postId, String postRating) {
		super();
		this.postId = postId;
		this.postRating = postRating;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostRating() {
		return postRating;
	}

	public void setPostRating(String postRating) {
		this.postRating = postRating;
	}
	
}
