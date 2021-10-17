package com.ncs.iss.ezlegal.tagging.master.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateMasterTagDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("tagName")
	private String tagName;

	@JsonProperty("tagDescription")
	private String tagDescription;

	@JsonProperty("status")
	private String status;

	public UpdateMasterTagDTO() {
		super();
	}

	public UpdateMasterTagDTO(String tagName, String tagDescription, String status) {
		super();
		this.tagName = tagName;
		this.tagDescription = tagDescription;
		this.status = status;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
