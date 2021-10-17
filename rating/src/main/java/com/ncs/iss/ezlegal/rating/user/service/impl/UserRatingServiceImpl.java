package com.ncs.iss.ezlegal.rating.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.UserRating;
import com.ncs.iss.ezlegal.rating.user.repository.UserRatingRepository;
import com.ncs.iss.ezlegal.rating.user.service.UserRatingService;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	UserRatingRepository urr;
	
	@Override
	public AddUserRatingResponseDTO addUserRating(AddUserRatingDTO request) {
		UserRating pr = urr.getUserRatingByUser(Integer.parseInt(request.getForUserId()), Integer.parseInt(request.getByUserId()));
		
		if(pr == null) {
			pr = new UserRating();
		}
		
		pr.setForUserId(Integer.parseInt(request.getForUserId()));
		pr.setByUserId(Integer.parseInt(request.getByUserId()));
		pr.setRating(Integer.parseInt(request.getRating()));
		UserRating updated = urr.save(pr);
		double averageRating = urr.getAverageUserRating(Integer.parseInt(request.getForUserId()));
		return new AddUserRatingResponseDTO(String.valueOf(updated.getForUserId()), String.valueOf(updated.getByUserId()), String.valueOf(updated.getRating()), String.format("%.2f",averageRating));
	}

	@Override
	public UpdateUserRatingResponseDTO updateUserRating(UpdateUserRatingDTO request) {
		UserRating pr = urr.getUserRatingByUser(Integer.parseInt(request.getForUserId()), Integer.parseInt(request.getByUserId()));
		
		if(pr == null) {
			pr = new UserRating();
			pr.setForUserId(Integer.parseInt(request.getForUserId()));
			pr.setByUserId(Integer.parseInt(request.getByUserId()));
		}
		
		pr.setRating(Integer.parseInt(request.getRating()));
		UserRating updated = urr.save(pr);
		double averageRating = urr.getAverageUserRating(Integer.parseInt(request.getForUserId()));
		return new UpdateUserRatingResponseDTO(String.valueOf(updated.getForUserId()), String.valueOf(updated.getByUserId()), String.valueOf(updated.getRating()), String.format("%.2f",averageRating));
	}

	@Override
	public GetUserRatingResponseDTO getUserRating(GetUserRatingDTO request) {
		double averageRating = urr.getAverageUserRating(Integer.parseInt(request.getForUserId()));
		return new GetUserRatingResponseDTO(String.valueOf(request.getForUserId()), String.format("%.2f",averageRating));
	}

	@Override
	public DeleteUserRatingResponseDTO deleteUserRating(DeleteUserRatingDTO request) {
		UserRating pr = urr.getUserRatingByUser(Integer.parseInt(request.getForUserId()), Integer.parseInt(request.getByUserId()));
		urr.delete(pr);
		double averageRating = urr.getAverageUserRating(Integer.parseInt(request.getForUserId()));
		return new DeleteUserRatingResponseDTO(String.valueOf(request.getForUserId()), String.valueOf(request.getByUserId()), String.format("%.2f",averageRating));
	}

}
