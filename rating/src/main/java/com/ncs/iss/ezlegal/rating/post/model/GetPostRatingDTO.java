package com.ncs.iss.ezlegal.rating.post.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPostRatingDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("postId")
	private String postId;

	public GetPostRatingDTO() {
		super();
	}

	public GetPostRatingDTO(String postId) {
		super();
		this.postId = postId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "GetPostRatingDTO [postId=" + postId + "]";
	}
	
}
