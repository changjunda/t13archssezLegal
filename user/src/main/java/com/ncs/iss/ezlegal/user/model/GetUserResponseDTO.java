package com.ncs.iss.ezlegal.user.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("sessionId")
	private String sessionId;
	
	@JsonProperty("isSessionActive")
	private String isSessionActive;
	
	@JsonProperty("lastLogin")
	private String lastLogin;
	
	@JsonProperty("role")
	private String role;
	
	@JsonProperty("rating")
	private String rating;
	
	@JsonProperty("tagList")	
	List<UserTagWrapperDTO> tagList;
	
	public GetUserResponseDTO() {
		super();
	}

	public GetUserResponseDTO(String userId, String email, String firstName, String lastName, String status,
			String sessionId, String isSessionActive, String lastLogin, String role, String rating,
			List<UserTagWrapperDTO> tagList) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.sessionId = sessionId;
		this.isSessionActive = isSessionActive;
		this.lastLogin = lastLogin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIsSessionActive() {
		return isSessionActive;
	}

	public void setIsSessionActive(String isSessionActive) {
		this.isSessionActive = isSessionActive;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
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
