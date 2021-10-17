package com.ncs.iss.ezlegal.rating.user.service;

import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.AddUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.DeleteUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.GetUserRatingResponseDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingDTO;
import com.ncs.iss.ezlegal.rating.user.model.UpdateUserRatingResponseDTO;

public interface UserRatingService {
	
	AddUserRatingResponseDTO addUserRating(AddUserRatingDTO request);

	UpdateUserRatingResponseDTO updateUserRating(UpdateUserRatingDTO request);

	GetUserRatingResponseDTO getUserRating(GetUserRatingDTO request);

	DeleteUserRatingResponseDTO deleteUserRating(DeleteUserRatingDTO request);
	
}
