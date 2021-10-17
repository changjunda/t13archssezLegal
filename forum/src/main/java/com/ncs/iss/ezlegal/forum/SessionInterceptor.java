package com.ncs.iss.ezlegal.forum;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ncs.iss.ezlegal.forum.service.SessionService;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	
	@Autowired
	SessionService ss;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		String sessionId = request.getParameter("sessionId");
		int i = 1;
		if(sessionId == null || sessionId.isEmpty()) {
			sessionId = request.getHeader("sessionId");
		}
		
		if(sessionId != null && !sessionId.isEmpty()) {
			i = ss.getUserId(sessionId);
		}
		
		request.setAttribute("userIndex", String.valueOf(i));
		
		boolean allow = true;
		
		if(!allow) {
			response.reset();
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid Session");
		}
		
		return allow;
	}
	
}
