package com.ncs.iss.ezlegal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.ncs.iss.ezlegal.user.model.UpdateUserDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserResponseDTO;
import com.ncs.iss.ezlegal.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping(value="/adduser" , consumes = "application/json")
	public ResponseEntity<AddUserResponseDTO> addUser(@RequestBody AddUserDTO request) {
		return new ResponseEntity<> (us.addUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/addlawyer" , consumes = "application/json")
	public ResponseEntity<AddUserResponseDTO> addLawyer(@RequestBody AddLawyerDTO request) {
		return new ResponseEntity<> (us.addLawyer(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateUserResponseDTO> updateUser(@RequestBody UpdateUserDTO request) {
		return new ResponseEntity<> (us.updateUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetUserResponseDTO> getUser(@RequestBody GetUserDTO request) {
		return new ResponseEntity<> (us.getUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/getbyemail" , consumes = "application/json")
	public ResponseEntity<GetUserEmailResponseDTO> getUserEmail(@RequestBody GetUserEmailDTO request) {
		return new ResponseEntity<> (us.getUserEmail(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/login" , consumes = "application/json")
	public ResponseEntity<LoginUserResponseDTO> loginUser(@RequestBody LoginUserDTO request) {
		return new ResponseEntity<> (us.loginUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/logout" , consumes = "application/json")
	public ResponseEntity<LogoutUserResponseDTO> logoutUser(@RequestBody LogoutUserDTO request) {
		return new ResponseEntity<> (us.logoutUser(request), HttpStatus.OK);
	}
	
}
