package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForumTagWrapperDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("forumTagId")
	private String forumTagId;
	
	@JsonProperty("forumId")
	private String forumId;
	
	@JsonProperty("tagId")
	private String tagId;
	
	@JsonProperty("tagName")
	private String tagName;
	
	@JsonProperty("tagDescription")
	private String tagDescription;
	
	public ForumTagWrapperDTO() {
		super();
	}

	public ForumTagWrapperDTO(String forumTagId, String forumId, String tagId, String tagName, String tagDescription) {
		super();
		this.forumTagId = forumTagId;
		this.forumId = forumId;
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDescription = tagDescription;
	}

	public String getForumTagId() {
		return forumTagId;
	}

	public void setForumTagId(String forumTagId) {
		this.forumTagId = forumTagId;
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

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	
}
