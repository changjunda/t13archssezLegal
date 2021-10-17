package com.ncs.iss.ezlegal.rating.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ncs.iss.ezlegal.rating.common.model.CustomAudit;

@Entity
@Table(name = "TB_USER_RATING")
public class UserRating extends CustomAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "FOR_USER_ID")
	private long forUserId;
	
	@Column(name = "BY_USER_ID")
	private int byUserId;
	
	@Column(name = "RATING")
	private int rating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getForUserId() {
		return forUserId;
	}

	public void setForUserId(long forUserId) {
		this.forUserId = forUserId;
	}

	public int getByUserId() {
		return byUserId;
	}

	public void setByUserId(int byUserId) {
		this.byUserId = byUserId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
