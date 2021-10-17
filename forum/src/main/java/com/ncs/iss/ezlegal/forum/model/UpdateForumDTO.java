package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateForumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("forumId")
	private String forumId;

	@JsonProperty("title")
	private String title;

	public UpdateForumDTO() {
		super();
	}

	public UpdateForumDTO(String forumId, String title) {
		super();
		this.forumId = forumId;
		this.title = title;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
