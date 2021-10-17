package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("postId")
	private String postId;

	@JsonProperty("content")
	private String content;

	public UpdatePostDTO() {
		super();
	}

	public UpdatePostDTO(String postId, String content) {
		super();
		this.postId = postId;
		this.content = content;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
