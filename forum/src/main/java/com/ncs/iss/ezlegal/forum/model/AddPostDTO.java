package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("forumId")
	private String forumId;

	@JsonProperty("content")
	private String content;

	public AddPostDTO() {
		super();
	}

	public AddPostDTO(String forumId, String content) {
		super();
		this.forumId = forumId;
		this.content = content;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
