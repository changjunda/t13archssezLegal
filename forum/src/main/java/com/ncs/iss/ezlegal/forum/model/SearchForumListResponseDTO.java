package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchForumListResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("forumList")
	List<GetForumResponseDTO> forumList;
	
	public SearchForumListResponseDTO() {
		super();
	}

	public SearchForumListResponseDTO(List<GetForumResponseDTO> forumList) {
		super();
		this.forumList = forumList;
	}

}
