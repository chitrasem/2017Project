package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.CourseDao;
import com.chitra.school.entities.Course;
import com.chitra.school.utils.StringUtils;

@RestController
@RequestMapping("/dashboard/course")
public class CourseRest{
	
	@Autowired
	CourseDao dao;
	
	@RequestMapping(value="/school_1004_0101_r001.chitra", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Map<String, Object> listCource()
	throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<Course> course = dao.findAllCourses();
			map.put("SUCCESS", true);
			map.put("courseRec", course);
		}catch(Exception e){
			map.put("SUCCESS", false);
			e.printStackTrace();
			map.put("MESSAGE", e.getMessage());
		}
		
		
		return map;
	}
	@RequestMapping(value="/school_1004_0102_c001.chitra", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveCource(){
		Map<String, Object> map = new HashMap<String, Object>();
		Course classroom = new Course();
		classroom.setCourse("ENGLISH IN COMMON 5");
		classroom.setDescritpion("New Class");
		
		classroom.setRegisterPerson(StringUtils.getPrincipal());
		try{
			dao.save(classroom);
			map.put("SUCCESS", true);
		}catch(Exception e){
			map.put("SUCCESS", false);
			map.put("MESSAGE", e.getMessage());
			e.printStackTrace();
		}
		
		return map;
	}
}
