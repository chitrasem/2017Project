package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.model.Memo;
import com.chitra.school.model.Student;
import com.chitra.school.model.User;
import com.chitra.school.service.MemoService;
import com.chitra.school.service.StudentService;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/service")
public class RestAdmin {
	
	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired 
	MemoService memoService;
	SSOIdUtil ssoIdUtil = new SSOIdUtil();

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
	@ResponseBody
	@RequestMapping(value="/school_1002_0302_c001.chitra", method=RequestMethod.POST)
	public Map<Object, Object> addStudents( 			
			@RequestBody String str
			)throws Exception{
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(str);
		
		Student student = mapper.convertValue(node.get("student"), Student.class);		
		User user = userService.findBySso(ssoIdUtil.getPrincipal());
		student.setRegisterPerson(user.getSsoId());		
		student.setRegisterDate("");
		
		Memo memo = mapper.convertValue(node.get("memo"), Memo.class);
		memo.setRegisterPerson(user.getSsoId());
		memo.setStudent(student);	

		student.setStudentId(studentService.getStudentId());
		
		try{
			studentService.save(student);	
			memoService.save(memo);
			map.put("success", true);		
		}catch(HibernateException e){
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}

}
