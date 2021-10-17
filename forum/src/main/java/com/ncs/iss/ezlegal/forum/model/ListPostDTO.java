package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListPostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("postList")
	private List<PostDTO> postList;
	
	public ListPostDTO() {
		super();
	}

	public ListPostDTO(List<PostDTO> postList) {
		super();
		this.postList = postList;
	}

	public List<PostDTO> getPostList() {
		return postList;
	}

	public void setPostList(List<PostDTO> postList) {
		this.postList = postList;
	}

}
