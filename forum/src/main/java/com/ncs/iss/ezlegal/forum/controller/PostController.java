package com.ncs.iss.ezlegal.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.forum.model.AddPostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostResponseDTO;
import com.ncs.iss.ezlegal.forum.model.GetPostDTO;
import com.ncs.iss.ezlegal.forum.model.ListPostDTO;
import com.ncs.iss.ezlegal.forum.model.PostDTO;
import com.ncs.iss.ezlegal.forum.model.SearchPostDTO;
import com.ncs.iss.ezlegal.forum.model.UpdatePostDTO;
import com.ncs.iss.ezlegal.forum.service.PostService;


@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	PostService ps;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<PostDTO> addPost(@RequestBody AddPostDTO request) {
		return new ResponseEntity<> (ps.addPost(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody UpdatePostDTO request) {
		return new ResponseEntity<> (ps.updatePost(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<PostDTO> getPost(@RequestBody GetPostDTO request) {
		return new ResponseEntity<> (ps.getPost(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeletePostResponseDTO> deletePost(@RequestBody DeletePostDTO request) {
		return new ResponseEntity<> (ps.deletePost(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/search" , consumes = "application/json")
	public ResponseEntity<ListPostDTO> searchPost(@RequestBody SearchPostDTO request) {
		return new ResponseEntity<> (ps.searchPost(request), HttpStatus.OK);
	}
	
}
