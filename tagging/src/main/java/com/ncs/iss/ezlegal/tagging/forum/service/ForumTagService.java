package com.ncs.iss.ezlegal.tagging.forum.service;

import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.AddForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.DeleteForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.GetForumTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagDTO;
import com.ncs.iss.ezlegal.tagging.forum.model.UpdateForumTagResponseDTO;

public interface ForumTagService {
	
	AddForumTagResponseDTO addForumTag(AddForumTagDTO request);

	UpdateForumTagResponseDTO updateForumTag(UpdateForumTagDTO request);

	GetForumTagResponseDTO getForumTag(GetForumTagDTO request);

	DeleteForumTagResponseDTO deleteForumTag(DeleteForumTagDTO request);
	
}
