package com.ncs.iss.ezlegal.forum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddForumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("title")
	private String title;

	public AddForumDTO() {
		super();
	}

	public AddForumDTO(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
