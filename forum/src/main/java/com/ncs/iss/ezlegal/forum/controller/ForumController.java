package com.ncs.iss.ezlegal.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.forum.model.AddForumDTO;
import com.ncs.iss.ezlegal.forum.model.AddForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.DeleteForumDTO;
import com.ncs.iss.ezlegal.forum.model.DeleteForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumListDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumListResponseDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.SearchForumListDTO;
import com.ncs.iss.ezlegal.forum.model.SearchForumListResponseDTO;
import com.ncs.iss.ezlegal.forum.model.UpdateForumDTO;
import com.ncs.iss.ezlegal.forum.model.UpdateForumResponseDTO;
import com.ncs.iss.ezlegal.forum.service.ForumService;

@RestController
@RequestMapping("forum")
public class ForumController {
	
	@Autowired
	ForumService fs;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddForumResponseDTO> addForum(@RequestBody AddForumDTO request) {
		return new ResponseEntity<> (fs.addForum(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateForumResponseDTO> updateForum(@RequestBody UpdateForumDTO request) {
		return new ResponseEntity<> (fs.updateForum(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetForumResponseDTO> getForum(@RequestBody GetForumDTO request) {
		return new ResponseEntity<> (fs.getForum(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/list" , consumes = "application/json")
	public ResponseEntity<GetForumListResponseDTO> getForumList(@RequestBody GetForumListDTO request) {
		return new ResponseEntity<> (fs.getForumList(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeleteForumResponseDTO> deleteForum(@RequestBody DeleteForumDTO request) {
		return new ResponseEntity<> (fs.deleteForum(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/search" , consumes = "application/json")
	public ResponseEntity<SearchForumListResponseDTO> searchForumList(@RequestBody SearchForumListDTO request) {
		return new ResponseEntity<> (fs.searchForumList(request), HttpStatus.OK);
	}
}
