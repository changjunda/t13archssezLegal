package com.ncs.iss.ezlegal.rating.post.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPostRatingDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("postId")
	private String postId;

	@JsonProperty("byUserId")
	private String byUserId;

	@JsonProperty("rating")
	private String rating;

	public AddPostRatingDTO() {
		super();
	}

	public AddPostRatingDTO(String postId, String byUserId, String rating) {
		super();
		this.postId = postId;
		this.byUserId = byUserId;
		this.rating = rating;
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

	@Override
	public String toString() {
		return "AddPostRatingDTO [postId=" + postId + ", byUserId=" + byUserId + ", rating=" + rating + "]";
	}
	
}
