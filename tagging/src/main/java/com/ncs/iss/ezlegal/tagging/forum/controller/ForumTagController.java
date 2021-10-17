package com.ncs.iss.ezlegal.tagging.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.service.ForumTagService;

@RestController
@RequestMapping("forumtag")
public class ForumTagController {
	
	@Autowired
	private ForumTagService fts;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddForumTagResponseDTO> addForumTag(@RequestBody AddForumTagDTO request) {
		return new ResponseEntity<> (fts.addForumTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateForumTagResponseDTO> updateForumTag(@RequestBody UpdateForumTagDTO request) {
		return new ResponseEntity<> (fts.updateForumTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetForumTagResponseDTO> getForumTag(@RequestBody GetForumTagDTO request) {
		return new ResponseEntity<> (fts.getForumTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeleteForumTagResponseDTO> deleteForumTag(@RequestBody DeleteForumTagDTO request) {
		return new ResponseEntity<> (fts.deleteForumTag(request), HttpStatus.OK);
	}
	
}
