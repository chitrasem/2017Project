package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.ClassroomDao;
import com.chitra.school.model.Classroom;

@RestController
@RequestMapping()
public class ClassroomRestController {
	
	@Autowired
	ClassroomDao dao;
	
	@RequestMapping(value="", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> listClassroom()
	throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<Classroom> classrooms = dao.findAllClassrooms("");
			map.put("SUCCESS", true);
			map.put("clsRoomRec", classrooms);
		}catch(Exception e){
			map.put("SUCCESS", false);
			e.printStackTrace();
			map.put("MESSAGE", e.getMessage());
		}
		
		
		return map;
	}
}
