package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddForumResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forumId")
	private String forumId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("createdDt")
	private String createdDt;

	@JsonProperty("createdById")
	private String createdById;
	
	@JsonProperty("createdByName")
	private String createdByName;
	
	public AddForumResponseDTO() {
		super();
	}

	public AddForumResponseDTO(String forumId, String title, String createdDt, String createdById, String createdByName) {
		super();
		this.forumId = forumId;
		this.title = title;
		this.createdDt = createdDt;
		this.createdById = createdById;
		this.createdByName = createdByName;
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

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

}
