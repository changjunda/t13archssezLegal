package com.ncs.iss.ezlegal.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.user.model.AddLawyerDTO;
import com.ncs.iss.ezlegal.user.model.AddUserDTO;
import com.ncs.iss.ezlegal.user.model.AddUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.GetUserDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailResponseDTO;
import com.ncs.iss.ezlegal.user.model.GetUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.Role;
import com.ncs.iss.ezlegal.user.model.UpdateUserDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.User;
import com.ncs.iss.ezlegal.user.model.UserTagWrapper;
import com.ncs.iss.ezlegal.user.model.UserTagWrapperDTO;
import com.ncs.iss.ezlegal.user.repository.RoleRepository;
import com.ncs.iss.ezlegal.user.repository.UserRepository;
import com.ncs.iss.ezlegal.user.repository.UserTagWrapperRepository;
import com.ncs.iss.ezlegal.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;

	@Autowired
	private RoleRepository rr;
	
	@Autowired
	private UserTagWrapperRepository utwr;

	@Override
	public AddUserResponseDTO addUser(AddUserDTO request) {
		User user = ur.getUserByEmail(request.getEmail());
		Role role = null;
		if(user == null) {
			User u = new User();
			u.setEmail(request.getEmail());
			u.setPassword(request.getPassword());
			u.setFirstName(request.getFirstName());
			u.setLastName(request.getLastName());
			u.setDob(null);
			u.setStatus("Y");
			u.setIsSessionActive("N");
			user = ur.save(u);
			
			Role r = new Role();
			r.setDescription("user");
			r.setUserId(user.getId());
			role = rr.save(r);
		} else {
			role = rr.getRoleByUserId(user.getId());
		}
		
		return new AddUserResponseDTO(String.valueOf(user.getId()), role.getDescription());
	}

	@Override
	public AddUserResponseDTO addLawyer(AddLawyerDTO request) {
		User user = ur.getUserByEmail(request.getEmail());
		Role role = null;
		if(user == null) {
			User u = new User();
			u.setEmail(request.getEmail());
			u.setPassword(request.getPassword());
			u.setFirstName(request.getFirstName());
			u.setLastName(request.getLastName());
			u.setDob(null);
			u.setStatus("Y");
			u.setIsSessionActive("N");
			user = ur.save(u);
			
			Role r = new Role();
			r.setDescription("lawyer");
			r.setUserId(user.getId());
			role = rr.save(r);
		} else {
			role = rr.getRoleByUserId(user.getId());
		}
		
		return new AddUserResponseDTO(String.valueOf(user.getId()), role.getDescription());
	}

	@Override
	public UpdateUserResponseDTO updateUser(UpdateUserDTO request) {
		User u = ur.getUserByUserId(Integer.parseInt(request.getUserId()));
		u.setEmail(request.getEmail());
		u.setPassword(request.getPassword());
		u.setFirstName(request.getFirstName());
		u.setLastName(request.getLastName());
		u.setDob(null);
		u.setStatus("Y");
		u.setIsSessionActive("N");
		User user = ur.save(u);
		
		Role role = rr.getRoleByUserId(user.getId());
		
		List<UserTagWrapper> tags = utwr.getUserTagWrapperByUserId(user.getId());
		List<UserTagWrapperDTO> urwdto = new ArrayList<>(); 
		int rating = utwr.getUserRating(user.getId());
		
		for(UserTagWrapper t : tags) {
			urwdto.add(new UserTagWrapperDTO(String.valueOf(t.getId()), String.valueOf(t.getForumId()), String.valueOf(t.getTagId()), t.getTagName(), t.getTagDescription()));
		}
		
		return new UpdateUserResponseDTO(String.valueOf(user.getId()), role.getDescription(), String.valueOf(rating), urwdto);
	}

	@Override
	public GetUserResponseDTO getUser(GetUserDTO request) {
		User u = ur.getUserByUserId(Integer.parseInt(request.getUserId()));
		String lastLogin = "N.A";
		
		if(u.getLastLogin() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
			lastLogin = formatter.format(u.getLastLogin());
		}
		
		Role role = rr.getRoleByUserId(u.getId());
		
		List<UserTagWrapper> tags = utwr.getUserTagWrapperByUserId(u.getId());
		List<UserTagWrapperDTO> urwdto = new ArrayList<>(); 
		int rating = utwr.getUserRating(u.getId());
		
		for(UserTagWrapper t : tags) {
			urwdto.add(new UserTagWrapperDTO(String.valueOf(t.getId()), String.valueOf(t.getForumId()), String.valueOf(t.getTagId()), t.getTagName(), t.getTagDescription()));
		}
		
		return new GetUserResponseDTO(String.valueOf(u.getId()), u.getEmail(), u.getFirstName(), u.getLastName(), u.getStatus(), u.getSessionId(), u.getIsSessionActive(), lastLogin, role.getDescription(), String.valueOf(rating), urwdto);
	}

	@Override
	public LoginUserResponseDTO loginUser(LoginUserDTO request) {
		
		User u = ur.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
		u.setIsSessionActive("Y");
		UUID uuid = UUID.randomUUID();
		u.setSessionId(uuid.toString());
		u.setLastLogin(new Date());
		
		ur.save(u);
		
		Role role = rr.getRoleByUserId(u.getId());
		
		return new LoginUserResponseDTO(String.valueOf(u.getId()), u.getSessionId(), role.getDescription());
	}

	@Override
	public LogoutUserResponseDTO logoutUser(LogoutUserDTO request) {
		String output = request.getUserId();
		User u = ur.getUserByIdAndSession(Integer.parseInt(request.getUserId()),request.getSessionId());
		
		if(u != null) {
			u.setIsSessionActive("N");
			u.setSessionId(null);
			User user = ur.save(u);
			output = String.valueOf(user.getId());
		}
		return new LogoutUserResponseDTO(output);
	}

	@Override
	public GetUserEmailResponseDTO getUserEmail(GetUserEmailDTO request) {
		User u = ur.getUserByEmail(request.getEmail());
		
		return new GetUserEmailResponseDTO(u == null ? "N" : "Y");
	}
	
	
	
}
