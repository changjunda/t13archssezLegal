package com.ncs.iss.ezlegal.forum.service;

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

public interface ForumService {
	
	AddForumResponseDTO addForum(AddForumDTO request);

	UpdateForumResponseDTO updateForum(UpdateForumDTO request);

	GetForumResponseDTO getForum(GetForumDTO request);

	GetForumListResponseDTO getForumList(GetForumListDTO request);

	DeleteForumResponseDTO deleteForum(DeleteForumDTO request);

	SearchForumListResponseDTO searchForumList(SearchForumListDTO request);
	
}
