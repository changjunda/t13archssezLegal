package com.ncs.iss.ezlegal.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.user.model.Session;
import com.ncs.iss.ezlegal.user.repository.SessionRepository;
import com.ncs.iss.ezlegal.user.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sr;

	@Override
	public int getUserId(String sessionId) {
		Session s = sr.getBySession(sessionId);
		
		if(s != null) {
			return s.getId();
		}
		
		return 1;
	}

	
}
