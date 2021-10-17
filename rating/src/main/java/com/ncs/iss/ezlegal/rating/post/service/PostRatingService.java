package com.ncs.iss.ezlegal.rating.post.service;

import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingResponseDTO;

public interface PostRatingService {
	
	AddPostRatingResponseDTO addPostRating(AddPostRatingDTO request);

	UpdatePostRatingResponseDTO updatePostRating(UpdatePostRatingDTO request);

	GetPostRatingResponseDTO getPostRating(GetPostRatingDTO request);

	DeletePostRatingResponseDTO deletePostRating(DeletePostRatingDTO request);
	
}
