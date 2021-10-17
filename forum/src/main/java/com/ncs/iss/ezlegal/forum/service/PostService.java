package com.ncs.iss.ezlegal.forum.service;

import com.ncs.iss.ezlegal.forum.model.AddPostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostResponseDTO;
import com.ncs.iss.ezlegal.forum.model.GetPostDTO;
import com.ncs.iss.ezlegal.forum.model.ListPostDTO;
import com.ncs.iss.ezlegal.forum.model.PostDTO;
import com.ncs.iss.ezlegal.forum.model.SearchPostDTO;
import com.ncs.iss.ezlegal.forum.model.UpdatePostDTO;

public interface PostService {
	
	PostDTO addPost(AddPostDTO request);

	PostDTO updatePost(UpdatePostDTO request);

	PostDTO getPost(GetPostDTO request);

	DeletePostResponseDTO deletePost(DeletePostDTO request);
	
	ListPostDTO searchPost(SearchPostDTO request);
}
