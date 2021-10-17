package com.ncs.iss.ezlegal.tagging.forum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.FTag;
import com.ncs.iss.ezlegal.tagging.forum.model.ForumTag;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.repository.ForumTagRepository;
import com.ncs.iss.ezlegal.tagging.forum.service.ForumTagService;

@Service
public class ForumTagServiceImpl implements ForumTagService {
	
	@Autowired
	private ForumTagRepository ftr;
	
	@Override
	public AddForumTagResponseDTO addForumTag(AddForumTagDTO request) {
		
		ForumTag ft = ftr.getTagByForumIdAndTagIdAndTagName(Long.parseLong(request.getForumId()), Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		
		if(ft == null) {
			ft = new ForumTag();
		}
		
		ft.setForumId(Long.parseLong(request.getForumId()));
		ft.setTagId(Long.parseLong(request.getTagId()));
		ft.setUserId(Integer.parseInt(request.getUserId()));
		
		ForumTag updatedFT = ftr.save(ft);
		
		return new AddForumTagResponseDTO(String.valueOf(updatedFT.getForumId()), String.valueOf(updatedFT.getTagId()), String.valueOf(updatedFT.getUserId()));
	}

	@Override
	public UpdateForumTagResponseDTO updateForumTag(UpdateForumTagDTO request) {

		ForumTag ft = ftr.getTagByForumIdAndTagIdAndTagName(Long.parseLong(request.getForumId()), Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		
		if(ft == null) {
			ft = new ForumTag();
		}
		
		ft.setForumId(Long.parseLong(request.getForumId()));
		ft.setTagId(Long.parseLong(request.getTagId()));
		ft.setUserId(Integer.parseInt(request.getUserId()));
		
		ForumTag updatedFT = ftr.save(ft);
		
		return new UpdateForumTagResponseDTO(String.valueOf(updatedFT.getForumId()), String.valueOf(updatedFT.getTagId()), String.valueOf(updatedFT.getUserId()));
		
	}

	@Override
	public GetForumTagResponseDTO getForumTag(GetForumTagDTO request) {
		
		List<ForumTag> tagsList = ftr.getAllByForumId(Long.parseLong(request.getForumId()));
		List<FTag> outputTag = new ArrayList<>();
		
		for(ForumTag tag : tagsList) {
			FTag t = new FTag(String.valueOf(tag.getForumId()), String.valueOf(tag.getTagId()), String.valueOf(tag.getUserId()));
			outputTag.add(t);
		}
		
		return new GetForumTagResponseDTO(outputTag);
	}

	@Override
	public DeleteForumTagResponseDTO deleteForumTag(DeleteForumTagDTO request) {
		ForumTag ft = ftr.getTagByForumIdAndTagIdAndTagName(Long.parseLong(request.getForumId()), Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		if(ft != null) {
			ftr.delete(ft);
		}
		
		List<ForumTag> tagsList = ftr.getAllByForumId(Long.parseLong(request.getForumId()));
		List<FTag> outputTag = new ArrayList<>();
		
		for(ForumTag tag : tagsList) {
			FTag t = new FTag(String.valueOf(tag.getForumId()), String.valueOf(tag.getTagId()), String.valueOf(tag.getUserId()));
			outputTag.add(t);
		}
		
		return new DeleteForumTagResponseDTO(outputTag);
	}
	
}
