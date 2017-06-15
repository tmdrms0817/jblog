package com.jx372.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jx372.jblog.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogservice;
	
	@RequestMapping(value = { "/{userID}", "/{userID}/{categoryNO}",
			"/{userID}/{categoryNO}/{postNo}" }, produces = "text/plain;charset=UTF-8")
	public String blogMain(
			@PathVariable("userID") Optional<String> userID,
			@PathVariable("categoryNO") Optional<String> categoryNO,
			@PathVariable("postNo") Optional<String> postNo,
			Model model) {

		if (categoryNO.isPresent()) {
			if(postNo.isPresent()){
				return "category와 post가 둘다 있습니다.";
			}
			return "category만 있습니다";
		}
		
		if(blogservice.getBlog(userID.get()) == null){
			System.out.println("생성된 블로그가 없습니다.");
			return "blog/NotFound";
		}
		
		model.addAttribute("userID", userID.get());
		return "blog/blog-main";
	}
}
