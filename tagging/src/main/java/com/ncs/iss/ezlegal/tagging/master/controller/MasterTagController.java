package com.ncs.iss.ezlegal.tagging.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.service.MasterTagService;

@RestController
@RequestMapping("mastertag")
public class MasterTagController {
	
	@Autowired
	private MasterTagService mts;
	
	@PostMapping(value="/add" , consumes = "application/json")
	public ResponseEntity<AddMasterTagResponseDTO> addMasterTag(@RequestBody AddMasterTagDTO request) {
		return new ResponseEntity<> (mts.addMasterTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateMasterTagResponseDTO> updateMasterTag(@RequestBody UpdateMasterTagDTO request) {
		return new ResponseEntity<> (mts.updateMasterTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetMasterTagResponseDTO> getMasterTag(@RequestBody GetMasterTagDTO request) {
		return new ResponseEntity<> (mts.getMasterTag(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/delete" , consumes = "application/json")
	public ResponseEntity<DeleteMasterTagResponseDTO> deleteMasterTag(@RequestBody DeleteMasterTagDTO request) {
		return new ResponseEntity<> (mts.deleteMasterTag(request), HttpStatus.OK);
	}
	
}
