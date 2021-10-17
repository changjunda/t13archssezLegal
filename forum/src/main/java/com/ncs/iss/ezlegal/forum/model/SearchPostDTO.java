package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchPostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("forumId")
	private String forumId;
	
	@JsonProperty("searchTerm")
	private String searchTerm;
	
	public SearchPostDTO() {
		super();
	}

	public SearchPostDTO(String forumId, String searchTerm) {
		super();
		this.forumId = forumId;
		this.searchTerm = searchTerm;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
