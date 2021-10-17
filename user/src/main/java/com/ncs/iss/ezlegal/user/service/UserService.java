package com.ncs.iss.ezlegal.user.service;

import com.ncs.iss.ezlegal.user.model.AddLawyerDTO;
import com.ncs.iss.ezlegal.user.model.AddUserDTO;
import com.ncs.iss.ezlegal.user.model.AddUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.GetUserDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailResponseDTO;
import com.ncs.iss.ezlegal.user.model.GetUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserResponseDTO;

public interface UserService {
	
	AddUserResponseDTO addUser(AddUserDTO request);
	
	AddUserResponseDTO addLawyer(AddLawyerDTO request);
	
	UpdateUserResponseDTO updateUser(UpdateUserDTO request);
	
	GetUserResponseDTO getUser(GetUserDTO request);

	GetUserEmailResponseDTO getUserEmail(GetUserEmailDTO request);

	LoginUserResponseDTO loginUser(LoginUserDTO request);

	LogoutUserResponseDTO logoutUser(LogoutUserDTO request);
	
}
