package com.ncs.iss.ezlegal.forum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostWrapper {
	
	@Id
	@Column(name = "POST_ID")
	private long postId;
	
	@Column(name = "FORUM_ID")
	private long forumId;
	
	@Column(name = "POST_SUBJECT")
	private String postSubject;
	
	@Column(name = "POST_CONTENT")
	private String postContent;
	
	@Column(name = "POST_CREATED_DATE")
	private Date postCreatedDt;
	
	@Column(name = "POST_CREATED_BY_ID")
	private int postCreatedById;
	
	@Column(name = "POST_CREATED_BY_NAME")
	private String postCreatedByName;
	
	@Column(name = "POST_COUNT")
	private int postCount;
	
	@Column(name = "POST_RATING")
	private double postRating;
	
	@Column(name = "USER_RATING")
	private double userRating;
	
	public PostWrapper() {
		super();
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
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

	public Date getPostCreatedDt() {
		return postCreatedDt;
	}

	public void setPostCreatedDt(Date postCreatedDt) {
		this.postCreatedDt = postCreatedDt;
	}

	public int getPostCreatedById() {
		return postCreatedById;
	}

	public void setPostCreatedById(int postCreatedById) {
		this.postCreatedById = postCreatedById;
	}

	public String getPostCreatedByName() {
		return postCreatedByName;
	}

	public void setPostCreatedByName(String postCreatedByName) {
		this.postCreatedByName = postCreatedByName;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public double getPostRating() {
		return postRating;
	}

	public void setPostRating(double postRating) {
		this.postRating = postRating;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}

}
