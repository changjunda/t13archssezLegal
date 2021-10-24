package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteDocumentDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("fileId")
	private int id;
	
	public DeleteDocumentDTO() {
		super();
	}
	
	public DeleteDocumentDTO(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
