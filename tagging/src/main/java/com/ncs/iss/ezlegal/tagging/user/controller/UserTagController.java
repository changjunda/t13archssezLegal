package com.ncs.iss.ezlegal.tagging.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.service.UserTagService;

@RestController
@RequestMapping("usertag")
public class UserTagController {
	
	@Autowired
	private UserTagService uts;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddUserTagResponseDTO> addUserTag(@RequestBody AddUserTagDTO request) {
		return new ResponseEntity<> (uts.addUserTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateUserTagResponseDTO> updateUserTag(@RequestBody UpdateUserTagDTO request) {
		return new ResponseEntity<> (uts.updateUserTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetUserTagResponseDTO> getUserTag(@RequestBody GetUserTagDTO request) {
		return new ResponseEntity<> (uts.getUserTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeleteUserTagResponseDTO> deleteUserTag(@RequestBody DeleteUserTagDTO request) {
		return new ResponseEntity<> (uts.deleteUserTag(request), HttpStatus.OK);
	}
	
}
