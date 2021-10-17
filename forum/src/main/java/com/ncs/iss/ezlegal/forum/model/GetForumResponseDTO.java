package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetForumResponseDTO implements Serializable {
	
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
	
	@JsonProperty("forumTag")
	private List<ForumTagWrapperDTO> forumTag;
	
	@JsonProperty("post")
	private List<PostDTO> post;
	
	public GetForumResponseDTO() {
		super();
	}

	public GetForumResponseDTO(String forumId, String title, String createdDt, String createdById, String createdByName,
			List<ForumTagWrapperDTO> forumTag, List<PostDTO> post) {
		super();
		this.forumId = forumId;
		this.title = title;
		this.createdDt = createdDt;
		this.createdById = createdById;
		this.createdByName = createdByName;
		this.forumTag = forumTag;
		this.post = post;
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

	public List<ForumTagWrapperDTO> getForumTag() {
		return forumTag;
	}

	public void setForumTag(List<ForumTagWrapperDTO> forumTag) {
		this.forumTag = forumTag;
	}

	public List<PostDTO> getPost() {
		return post;
	}

	public void setPost(List<PostDTO> post) {
		this.post = post;
	}
	
}
