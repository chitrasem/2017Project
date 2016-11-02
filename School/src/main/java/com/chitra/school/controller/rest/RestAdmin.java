package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/school_1002_0302_c001.chitra", method=RequestMethod.POST)
	public Map<Object, Object> addStudents( 
			@RequestParam("firstName") String firstName
			,@RequestParam("lastName") String lastName
			,@RequestParam("kmFirstName") String kmFirstName
			,@RequestParam("kmLastName") String kmLastName
			,@RequestParam("gender") String gender
			,@RequestParam("birthDate") String birthDate
			){
		Map<Object, Object> map = new HashMap<Object, Object>();
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setKmFirstName(kmFirstName);
		student.setKmLastName(kmLastName);
		student.setGender(gender);
		student.setBirthDate(birthDate);

		map.put("abc", student.getFirstName());
		
		try{
			studentService.save(student);			
			map.put("success", true);		
			map.put("abc", student.getFirstName());
		}catch(HibernateException e){
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}

}
