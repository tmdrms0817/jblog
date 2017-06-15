package com.jx372.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jx372.jblog.service.UserService;
import com.jx372.jblog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userservice;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVo userVo = userservice.getUser( id, password );
		if(userVo==null){
			response.sendRedirect(request.getContextPath() + "/user/login?result=fail" );
			return false;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		response.sendRedirect( request.getContextPath() + "/" );
		return false;
	}

	
}
