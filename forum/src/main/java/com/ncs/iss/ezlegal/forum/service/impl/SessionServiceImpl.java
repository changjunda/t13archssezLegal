package com.ncs.iss.ezlegal.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.forum.model.Session;
import com.ncs.iss.ezlegal.forum.repository.SessionRepository;
import com.ncs.iss.ezlegal.forum.service.SessionService;

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
