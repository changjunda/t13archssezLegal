package com.ncs.iss.ezlegal.tagging.user.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserTagResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tags")
	private List<UTag> tags;
	
	public DeleteUserTagResponseDTO() {
		super();
	}

	public DeleteUserTagResponseDTO(List<UTag> tags) {
		super();
		this.tags = tags;
	}

	public List<UTag> getTags() {
		return tags;
	}

	public void setTags(List<UTag> tags) {
		this.tags = tags;
	}

}
