package com.ncs.iss.ezlegal.tagging.master.service;

import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.AddMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.DeleteMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.GetMasterTagResponseDTO;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagDTO;
import com.ncs.iss.ezlegal.tagging.master.model.UpdateMasterTagResponseDTO;

public interface MasterTagService {
	
	AddMasterTagResponseDTO addMasterTag(AddMasterTagDTO request);

	UpdateMasterTagResponseDTO updateMasterTag(UpdateMasterTagDTO request);

	GetMasterTagResponseDTO getMasterTag(GetMasterTagDTO request);

	DeleteMasterTagResponseDTO deleteMasterTag(DeleteMasterTagDTO request);
	
}
