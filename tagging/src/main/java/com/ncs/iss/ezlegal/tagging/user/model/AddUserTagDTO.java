package com.ncs.iss.ezlegal.tagging.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserTagDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tagId")
	private String tagId;

	@JsonProperty("userId")
	private String userId;

	public AddUserTagDTO() {
		super();
	}

	public AddUserTagDTO(String tagId, String userId) {
		super();
		this.tagId = tagId;
		this.userId = userId;
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
