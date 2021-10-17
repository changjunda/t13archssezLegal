package com.ncs.iss.ezlegal.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_POST")
public class Post extends CustomAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "FORUM_ID")
	private long forumId;
	
	@Column(name = "REPLY_TO")
	private int replyTo;
	
	@Column(name = "CONTENT")
	private String content;
	
	public Post() {
		super();
	}

	public Post(long id, long forumId, int replyTo, String content) {
		super();
		this.id = id;
		this.forumId = forumId;
		this.replyTo = replyTo;
		this.content = content;
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

	public int getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(int replyTo) {
		this.replyTo = replyTo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
