package com.ncs.iss.ezlegal.tagging.master.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMasterTagResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tags")
	private List<MTag> tags;
	
	public GetMasterTagResponseDTO() {
		super();
	}

	public GetMasterTagResponseDTO(List<MTag> tags) {
		super();
		this.tags = tags;
	}

	public List<MTag> getTags() {
		return tags;
	}

	public void setTags(List<MTag> tags) {
		this.tags = tags;
	}
	
}
