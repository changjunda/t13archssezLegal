package com.ncs.iss.ezlegal.tagging.common.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "CREATED_DATE", "UPDATED_DATE" }, allowGetters = true)
public abstract class CustomAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATED_DATE", nullable = false, insertable = true, updatable = false)
	@CreatedDate
	private Instant createdDate;

	@Column(name = "UPDATED_DATE", nullable = true, insertable = false, updatable = true)
	@LastModifiedDate
	private Instant updatedDate;
	
	@Column(name = "CREATED_BY", nullable = false, insertable = true, updatable = false)
	@CreatedBy
	private String createdBy;
	
	@Column(name = "UPDATED_BY", nullable = true, insertable = false, updatable = true)
	@LastModifiedBy
	private String updatedBy;

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@PrePersist
	public void prePersistFunction () {
		if (this.createdBy == null) {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			if(request != null) {
				String userIndex = (String) request.getAttribute("userIndex");
				if(userIndex == null || userIndex.isEmpty()) {
					this.createdBy = "1";
				} else {
					this.createdBy = userIndex;
				}
			} else {
				this.createdBy = "1";
			}
		}
	}
	
	@PreUpdate
	public void preUpdateFunction () {
		
		if (this.updatedBy == null) {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			if(request != null) {
				String userIndex = (String) request.getAttribute("userIndex");
				if(userIndex == null || userIndex.isEmpty()) {
					this.updatedBy = "1";
				} else {
					this.updatedBy = userIndex;
				}
			} else {
				this.updatedBy = "1";
			}
		}
		
	}
	

}