package com.ncs.iss.ezlegal.tagging.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UTag;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UserTag;
import com.ncs.iss.ezlegal.tagging.user.repository.UserTagRepository;
import com.ncs.iss.ezlegal.tagging.user.service.UserTagService;

@Service
public class UserTagServiceImpl implements UserTagService {
	
	@Autowired
	private UserTagRepository utr;
	
	@Override
	public AddUserTagResponseDTO addUserTag(AddUserTagDTO request) {
		
		UserTag ut = utr.getTagByTagIdAndTagName(Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		
		if(ut == null) {
			ut = new UserTag();
		}
		
		ut.setTagId(Long.parseLong(request.getTagId()));
		ut.setUserId(Integer.parseInt(request.getUserId()));
		
		UserTag updatedUT = utr.save(ut);
		
		return new AddUserTagResponseDTO(String.valueOf(updatedUT.getTagId()), String.valueOf(updatedUT.getUserId()));
	}

	@Override
	public UpdateUserTagResponseDTO updateUserTag(UpdateUserTagDTO request) {

		UserTag ut = utr.getTagByTagIdAndTagName(Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		
		if(ut == null) {
			ut = new UserTag();
		}
		
		ut.setTagId(Long.parseLong(request.getTagId()));
		ut.setUserId(Integer.parseInt(request.getUserId()));
		
		UserTag updatedUT = utr.save(ut);
		
		return new UpdateUserTagResponseDTO(String.valueOf(updatedUT.getTagId()), String.valueOf(updatedUT.getUserId()));
		
	}

	@Override
	public GetUserTagResponseDTO getUserTag(GetUserTagDTO request) {
		
		List<UserTag> tagsList = utr.getAllByUserId(Integer.parseInt(request.getUserId()));
		List<UTag> outputTag = new ArrayList<>();
		
		for(UserTag tag : tagsList) {
			UTag t = new UTag(String.valueOf(tag.getTagId()), String.valueOf(tag.getUserId()));
			outputTag.add(t);
		}
		
		return new GetUserTagResponseDTO(outputTag);
	}

	@Override
	public DeleteUserTagResponseDTO deleteUserTag(DeleteUserTagDTO request) {
		UserTag ut = utr.getTagByTagIdAndTagName(Long.parseLong(request.getTagId()), Integer.parseInt(request.getUserId()));
		if(ut != null) {
			utr.delete(ut);
		}
		
		List<UserTag> tagsList = utr.getAllByUserId(Integer.parseInt(request.getUserId()));
		List<UTag> outputTag = new ArrayList<>();
		
		for(UserTag tag : tagsList) {
			UTag t = new UTag(String.valueOf(tag.getTagId()), String.valueOf(tag.getUserId()));
			outputTag.add(t);
		}
		
		return new DeleteUserTagResponseDTO(outputTag);
	}
	
}
