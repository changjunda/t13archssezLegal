package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("role")
	private String role;
	
	@JsonProperty("rating")
	private String rating;
	
	@JsonProperty("tagList")	
	List<UserTagWrapperDTO> tagList;
	
	public UpdateUserResponseDTO() {
		super();
	}

	public UpdateUserResponseDTO(String userId, String role, String rating, List<UserTagWrapperDTO> tagList) {
		super();
		this.userId = userId;
		this.role = role;
		this.rating = rating;
		this.tagList = tagList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<UserTagWrapperDTO> getTagList() {
		return tagList;
	}

	public void setTagList(List<UserTagWrapperDTO> tagList) {
		this.tagList = tagList;
	}

}
