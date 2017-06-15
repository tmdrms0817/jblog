package com.jx372.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.jblog.service.UserService;
import com.jx372.jblog.vo.UserVo;
import com.jx372.util.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo, BindingResult result , Model model) {
		
		new UserValidator().validate(vo, result);
		
		if(result.hasErrors()){
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		service.join(vo);
		return "redirect:/user/joinsuccess";
		
	}
	
	@RequestMapping(value = "/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "user/login";
	}


}
