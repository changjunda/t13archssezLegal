package com.ncs.iss.ezlegal.tagging.master.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateMasterTagResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forumId")
	private String forumId;

	@JsonProperty("tagId")
	private String tagId;

	@JsonProperty("userId")
	private String userId;

	public UpdateMasterTagResponseDTO() {
		super();
	}

	public UpdateMasterTagResponseDTO(String forumId, String tagId, String userId) {
		super();
		this.forumId = forumId;
		this.tagId = tagId;
		this.userId = userId;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
