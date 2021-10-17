package com.ncs.iss.ezlegal.rating.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.service.UserRatingService;

@RestController
@RequestMapping("userrating")
public class UserRatingController {
	
	@Autowired
	UserRatingService urs;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddUserRatingResponseDTO> addUserRating(@RequestBody AddUserRatingDTO request) {
		return new ResponseEntity<> (urs.addUserRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateUserRatingResponseDTO> updateUserRating(@RequestBody UpdateUserRatingDTO request) {
		return new ResponseEntity<> (urs.updateUserRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetUserRatingResponseDTO> getUserRating(@RequestBody GetUserRatingDTO request) {
		return new ResponseEntity<> (urs.getUserRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeleteUserRatingResponseDTO> deleteUserRating(@RequestBody DeleteUserRatingDTO request) {
		return new ResponseEntity<> (urs.deleteUserRating(request), HttpStatus.OK);
	}
	
}
