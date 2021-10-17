package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetForumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forumId")
	private String forumId;

	public GetForumDTO() {
		super();
	}

	public GetForumDTO(String forumId) {
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
