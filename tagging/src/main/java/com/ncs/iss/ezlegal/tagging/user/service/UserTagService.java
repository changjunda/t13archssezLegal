package com.ncs.iss.ezlegal.tagging.user.service;

import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.AddUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.DeleteUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.GetUserTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagDTO;
import com.ncs.iss.ezlegal.tagging.user.model.UpdateUserTagResponseDTO;

public interface UserTagService {
	
	AddUserTagResponseDTO addUserTag(AddUserTagDTO request);

	UpdateUserTagResponseDTO updateUserTag(UpdateUserTagDTO request);

	GetUserTagResponseDTO getUserTag(GetUserTagDTO request);

	DeleteUserTagResponseDTO deleteUserTag(DeleteUserTagDTO request);
	
}
