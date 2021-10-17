package com.ncs.iss.ezlegal.tagging.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.MasterTag;
import com.ncs.iss.ezlegal.tagging.master.model.MTag;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.repository.MasterTagRepository;
import com.ncs.iss.ezlegal.tagging.master.service.MasterTagService;

@Service
public class MasterTagServiceImpl implements MasterTagService {
	
	@Autowired
	private MasterTagRepository mtr;
	
	@Override
	public AddMasterTagResponseDTO addMasterTag(AddMasterTagDTO request) {
		
		MasterTag mt = mtr.getTagByTagName(request.getTagName());
		
		if(mt == null) {
			mt = new MasterTag();
		}
		
		mt.setTagName(request.getTagName());
		mt.setTagDescription(request.getTagDescription());
		mt.setStatus(request.getStatus());
		
		MasterTag updatedMT = mtr.save(mt);
		
		return new AddMasterTagResponseDTO(updatedMT.getTagName(), updatedMT.getTagDescription(), updatedMT.getStatus());
	}

	@Override
	public UpdateMasterTagResponseDTO updateMasterTag(UpdateMasterTagDTO request) {

		MasterTag mt = mtr.getTagByTagName(request.getTagName());
		
		if(mt == null) {
			mt = new MasterTag();
		}
		
		mt.setTagName(request.getTagName());
		mt.setTagDescription(request.getTagDescription());
		mt.setStatus(request.getStatus());
		
		MasterTag updatedMT = mtr.save(mt);
		
		return new UpdateMasterTagResponseDTO(updatedMT.getTagName(), updatedMT.getTagDescription(), updatedMT.getStatus());
		
	}

	@Override
	public GetMasterTagResponseDTO getMasterTag(GetMasterTagDTO request) {
		
		List<MasterTag> tagsList = mtr.getTag();
		List<MTag> outputTag = new ArrayList<>();
		
		for(MasterTag tag : tagsList) {
			MTag t = new MTag(tag.getTagName(), tag.getTagDescription(), tag.getStatus());
			outputTag.add(t);
		}
		
		return new GetMasterTagResponseDTO(outputTag);
	}

	@Override
	public DeleteMasterTagResponseDTO deleteMasterTag(DeleteMasterTagDTO request) {
		MasterTag mt = mtr.getTagByTagName(request.getTagName());
		if(mt != null) {
			mtr.delete(mt);
		}
		
		List<MasterTag> tagsList = mtr.getTag();
		List<MTag> outputTag = new ArrayList<>();
		
		for(MasterTag tag : tagsList) {
			MTag t = new MTag(tag.getTagName(), tag.getTagDescription(), tag.getStatus());
			outputTag.add(t);
		}
		
		return new DeleteMasterTagResponseDTO(outputTag);
	}
	
}
