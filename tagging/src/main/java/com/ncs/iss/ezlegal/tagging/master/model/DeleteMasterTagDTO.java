package com.ncs.iss.ezlegal.tagging.master.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMasterTagDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tagName")
	private String tagName;
	
	public DeleteMasterTagDTO() {
		super();
	}

	public DeleteMasterTagDTO(String tagName) {
		super();
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
