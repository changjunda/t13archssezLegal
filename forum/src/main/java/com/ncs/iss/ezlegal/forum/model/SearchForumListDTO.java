package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchForumListDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("searchTerm")
	private String searchTerm;
	
	public SearchForumListDTO() {
		super();
	}

	public SearchForumListDTO(String searchTerm) {
		super();
		this.searchTerm = searchTerm;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
