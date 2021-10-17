package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeletePostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("postId")
	private String postId;

	public DeletePostDTO() {
		super();
	}

	public DeletePostDTO(String postId) {
		super();
		this.postId = postId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

}
