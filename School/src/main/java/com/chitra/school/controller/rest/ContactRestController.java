package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.StudentDao;
import com.chitra.school.model.User;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;

@RestController
@RequestMapping("/dashboard")
public class ContactRestController {
	@Autowired
	StudentDao studentService;
	@Autowired
	UserService userService;
	
	
	SSOIdUtil sSOIdUtil;
	
	@RequestMapping(value = { "/contactlist"}, method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody Map<String, Object> findAllStudnet() {
		sSOIdUtil = new SSOIdUtil();		
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("MESSAGE", "TESTING");
		map.put("REC", user);		
		return map;
	}

}
