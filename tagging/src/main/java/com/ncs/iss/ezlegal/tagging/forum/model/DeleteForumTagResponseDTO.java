package com.ncs.iss.ezlegal.tagging.forum.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteForumTagResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tags")
	private List<FTag> tags;
	
	public DeleteForumTagResponseDTO() {
		super();
	}

	public DeleteForumTagResponseDTO(List<FTag> tags) {
		super();
		this.tags = tags;
	}

	public List<FTag> getTags() {
		return tags;
	}

	public void setTags(List<FTag> tags) {
		this.tags = tags;
	}

}
