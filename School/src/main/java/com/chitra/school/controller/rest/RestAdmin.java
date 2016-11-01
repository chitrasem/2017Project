package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.model.Student;
import com.chitra.school.model.User;
import com.chitra.school.service.StudentService;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;

@RestController
@RequestMapping("/service")
public class RestAdmin {
	
	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/school_1002_0101_r001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> getUsers(SSOIdUtil ssoIdUtil) {
		Map<Object, Object> map = new HashMap<Object, Object>();		
		List<User> users = userService.findAllUsers();		
		map.put("UserRec",users);
		map.put("success", true);

		return map;
	}
	@RequestMapping(value="/school_1002_0301_r001.chitra", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> getStudents(SSOIdUtil ssoId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		List<Student> students = studentService.findAll();
		map.put("StudentRec", students);
		map.put("success", true);
		
		
		return map;
	}

}
