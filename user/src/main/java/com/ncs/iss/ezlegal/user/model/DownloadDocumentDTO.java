package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DownloadDocumentDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("fileId")
	private int id;
	
	public DownloadDocumentDTO() {
		super();
	}
	
	public DownloadDocumentDTO(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
