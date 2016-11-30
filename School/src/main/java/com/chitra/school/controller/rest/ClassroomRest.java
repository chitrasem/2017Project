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

import com.chitra.school.dao.ClassroomDao;
import com.chitra.school.model.Classroom;
import com.chitra.school.utils.StringUtils;

@RestController
@RequestMapping("/dashboard/classroom")
public class ClassroomRest{
	
	@Autowired
	ClassroomDao dao;
	
	@RequestMapping(value="/school_1004_0101.chitra", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Map<String, Object> listClassroom()
	throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<Classroom> classrooms = dao.findAllClassrooms();
			map.put("SUCCESS", true);
			map.put("clsRoomRec", classrooms);
		}catch(Exception e){
			map.put("SUCCESS", false);
			e.printStackTrace();
			map.put("MESSAGE", e.getMessage());
		}
		
		
		return map;
	}
	@RequestMapping(value="/school_1004_0102.chitra", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveClassroom(){
		Map<String, Object> map = new HashMap<String, Object>();
		Classroom classroom = new Classroom();
		classroom.setClassroom("ENGLISH IN COMMON 5");
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
