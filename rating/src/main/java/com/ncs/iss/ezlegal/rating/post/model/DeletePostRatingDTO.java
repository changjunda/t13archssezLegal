package com.ncs.iss.ezlegal.rating.post.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeletePostRatingDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("postId")
	private String postId;

	@JsonProperty("byUserId")
	private String byUserId;

	public DeletePostRatingDTO() {
		super();
	}

	public DeletePostRatingDTO(String postId, String byUserId) {
		super();
		this.postId = postId;
		this.byUserId = byUserId;
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

	@Override
	public String toString() {
		return "DeletePostRatingDTO [postId=" + postId + ", byUserId=" + byUserId + "]";
	}
	
}
