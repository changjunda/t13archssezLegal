package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("postId")
	private String postId;

	@JsonProperty("postSubject")
	private String postSubject;

	@JsonProperty("postContent")
	private String postContent;
	
	@JsonProperty("postCreatedDt")
	private String postCreatedDt;
	
	@JsonProperty("postCreatedById")
	private String postCreatedById;
	
	@JsonProperty("postCreatedByName")
	private String postCreatedByName;

	@JsonProperty("postCount")
	private String postCount;	
	
	@JsonProperty("postRating")
	private String postRating;

	@JsonProperty("userRating")
	private String userRating;
	
	public PostDTO() {
		super();
	}

	public PostDTO(String postId, String postSubject, String postContent, String postCreatedDt, String postCreatedById,
			String postCreatedByName, String postCount, String postRating, String userRating) {
		super();
		this.postId = postId;
		this.postSubject = postSubject;
		this.postContent = postContent;
		this.postCreatedDt = postCreatedDt;
		this.postCreatedById = postCreatedById;
		this.postCreatedByName = postCreatedByName;
		this.postCount = postCount;
		this.postRating = postRating;
		this.userRating = userRating;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCreatedDt() {
		return postCreatedDt;
	}

	public void setPostCreatedDt(String postCreatedDt) {
		this.postCreatedDt = postCreatedDt;
	}

	public String getPostCreatedById() {
		return postCreatedById;
	}

	public void setPostCreatedById(String postCreatedById) {
		this.postCreatedById = postCreatedById;
	}

	public String getPostCreatedByName() {
		return postCreatedByName;
	}

	public void setPostCreatedByName(String postCreatedByName) {
		this.postCreatedByName = postCreatedByName;
	}

	public String getPostCount() {
		return postCount;
	}

	public void setPostCount(String postCount) {
		this.postCount = postCount;
	}

	public String getPostRating() {
		return postRating;
	}

	public void setPostRating(String postRating) {
		this.postRating = postRating;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
