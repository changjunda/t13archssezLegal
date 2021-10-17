package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetForumListResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("forumList")
	List<GetForumResponseDTO> forumList;
	
	public GetForumListResponseDTO() {
		super();
	}

	public GetForumListResponseDTO(List<GetForumResponseDTO> forumList) {
		super();
		this.forumList = forumList;
	}

}
