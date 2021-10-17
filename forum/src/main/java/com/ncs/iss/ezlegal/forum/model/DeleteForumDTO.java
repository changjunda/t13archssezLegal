package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteForumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forumId")
	private String forumId;

	public DeleteForumDTO() {
		super();
	}

	public DeleteForumDTO(String forumId) {
		super();
		this.forumId = forumId;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

}
