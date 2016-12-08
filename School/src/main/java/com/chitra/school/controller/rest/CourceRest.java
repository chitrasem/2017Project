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

import com.chitra.school.dao.CourceDao;
import com.chitra.school.model.Cources;
import com.chitra.school.utils.StringUtils;

@RestController
@RequestMapping("/dashboard/classroom")
public class CourceRest{
	
	@Autowired
	CourceDao dao;
	
	@RequestMapping(value="/school_1004_0101_r001.chitra", method= RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Map<String, Object> listCource()
	throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<Cources> classrooms = dao.findAllClassrooms();
			map.put("SUCCESS", true);
			map.put("clsRoomRec", classrooms);
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
		Cources classroom = new Cources();
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
