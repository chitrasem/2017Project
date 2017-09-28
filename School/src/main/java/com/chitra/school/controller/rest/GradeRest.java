package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.GradeDao;
import com.chitra.school.entities.Grade;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/dashboard")
public class GradeRest {

	@Autowired
	GradeDao dao;
	@RequestMapping(value="/classroom/school_1004_0101_r001.chitra", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> getGrade(){
		Map<Object, Object> map = new HashMap<Object, Object>();	
		try{
			List<Grade> grade =  dao.getGrade();
			map.put("success", true);
			map.put("GradeRec", grade);
		}catch(Exception e){
			map.put("success", false);
			map.put("message",e.getMessage());
			e.printStackTrace();			
		}
		return map;
	}
	@RequestMapping(value="/classroom/school_1004_0101_c001.chitra",method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> saveGrade(@RequestBody String str)
	{
		Map<Object, Object> map = new HashMap<Object, Object>();	
		
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(str);	
			Grade grade = mapper.convertValue(node.get("grade"), Grade.class);	
			dao.saveGrade(grade);
			map.put("success", false);			
		}catch(Exception e){
			map.put("success", false);
			map.put("message",e.getMessage());
			e.printStackTrace();
			
		}
		return map;
	}
}
