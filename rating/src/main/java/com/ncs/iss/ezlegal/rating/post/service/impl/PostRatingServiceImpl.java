package com.ncs.iss.ezlegal.rating.post.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.AddPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.DeletePostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.GetPostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.model.PostRating;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingDTO;
import com.ncs.iss.ezlegal.rating.post.model.UpdatePostRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.post.repository.PostRatingRepository;
import com.ncs.iss.ezlegal.rating.post.service.PostRatingService;

@Service
public class PostRatingServiceImpl implements PostRatingService {

	@Autowired
	PostRatingRepository prr;
	
	@Override
	public AddPostRatingResponseDTO addPostRating(AddPostRatingDTO request) {
		PostRating pr = prr.getPostRatingByIdAndUser(Long.parseLong(request.getPostId()), Integer.parseInt(request.getByUserId()));
		
		if(pr == null) {
			pr = new PostRating();
		}
		
		pr.setPostId(Integer.parseInt(request.getPostId()));
		pr.setByUserId(Integer.parseInt(request.getByUserId()));
		pr.setRating(Integer.parseInt(request.getRating()));
		PostRating updated = prr.save(pr);
		double averageRating = prr.getAveragePostRating(Integer.parseInt(request.getPostId()));
		return new AddPostRatingResponseDTO(String.valueOf(updated.getPostId()), String.valueOf(updated.getByUserId()), String.valueOf(updated.getRating()), String.format("%.2f",averageRating));
	}

	@Override
	public UpdatePostRatingResponseDTO updatePostRating(UpdatePostRatingDTO request) {
		PostRating pr = prr.getPostRatingByIdAndUser(Long.parseLong(request.getPostId()), Integer.parseInt(request.getByUserId()));
		if(pr == null) {
			pr = new PostRating();
			pr.setPostId(Integer.parseInt(request.getPostId()));
			pr.setByUserId(Integer.parseInt(request.getByUserId()));
		}
		pr.setRating(Integer.parseInt(request.getRating()));
		PostRating updated = prr.save(pr);
		double averageRating = prr.getAveragePostRating(Integer.parseInt(request.getPostId()));
		return new UpdatePostRatingResponseDTO(String.valueOf(updated.getPostId()), String.valueOf(updated.getByUserId()), String.valueOf(updated.getRating()), String.format("%.2f",averageRating));
	}

	@Override
	public GetPostRatingResponseDTO getPostRating(GetPostRatingDTO request) {
		double averageRating = prr.getAveragePostRating(Integer.parseInt(request.getPostId()));
		return new GetPostRatingResponseDTO(String.valueOf(request.getPostId()), String.format("%.2f",averageRating));
	}

	@Override
	public DeletePostRatingResponseDTO deletePostRating(DeletePostRatingDTO request) {
		PostRating pr = prr.getPostRatingByIdAndUser(Long.parseLong(request.getPostId()), Integer.parseInt(request.getByUserId()));
		prr.delete(pr);
		double averageRating = prr.getAveragePostRating(Integer.parseInt(request.getPostId()));
		return new DeletePostRatingResponseDTO(String.valueOf(request.getPostId()), String.valueOf(request.getByUserId()), String.format("%.2f",averageRating));
	}

}
