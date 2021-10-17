package com.ncs.iss.ezlegal.rating.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.service.PostRatingService;

@RestController
@RequestMapping("postrating")
public class PostRatingController {
	
	@Autowired
	PostRatingService prs;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddPostRatingResponseDTO> addPostRating(@RequestBody AddPostRatingDTO request) {
		return new ResponseEntity<> (prs.addPostRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdatePostRatingResponseDTO> updatePostRating(@RequestBody UpdatePostRatingDTO request) {
		return new ResponseEntity<> (prs.updatePostRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetPostRatingResponseDTO> getPostRating(@RequestBody GetPostRatingDTO request) {
		return new ResponseEntity<> (prs.getPostRating(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeletePostRatingResponseDTO> deletePostRating(@RequestBody DeletePostRatingDTO request) {
		return new ResponseEntity<> (prs.deletePostRating(request), HttpStatus.OK);
	}
	
}
