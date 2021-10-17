package com.ncs.iss.ezlegal.tagging.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ncs.iss.ezlegal.tagging.common.model.CustomAudit;

@Entity
@Table(name = "TB_MASTER_TAG")
public class MasterTag extends CustomAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "TAG_NAME")
	private String tagName;
	
	@Column(name = "TAG_DESCRIPTION")
	private String tagDescription;
	
	@Column(name = "STATUS")
	private String status;
	
	public MasterTag() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
