package com.ncs.iss.ezlegal.tagging.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ncs.iss.ezlegal.tagging.common.model.CustomAudit;

@Entity
@Table(name = "TB_FORUM_TAG")
public class ForumTag extends CustomAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "FORUM_ID")
	private long forumId;
	
	@Column(name = "TAG_ID")
	private long tagId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	public ForumTag() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
