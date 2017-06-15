package com.jx372.jblog.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx372.jblog.service.UserService;

@Controller
@RequestMapping("/user/api")
public class UserApiController {

	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public Map<String, Object> checkID(@RequestParam(value="id",required=true,defaultValue="") String id){
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put( "result", "success" );
		map.put( "data", service.checkID(id) );
		
		return map;
	}
	
}
