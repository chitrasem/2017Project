package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.bean.DashboardBean;
import com.chitra.school.dao.DashboardDao;

@RestController
@RequestMapping("/dashboard")
public class DashboardRest {	
	
	@Autowired
	DashboardDao dao;
	@RequestMapping(value = "/school_1001_0101.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> dashboardInfo(){
		Map<Object, Object> m = new HashMap<Object, Object>();
		try{
			List<DashboardBean> dsList = dao.list();
			m.put("status", true);
			m.put("dsRec", dsList);
		}catch(Exception e){
			m.put("status", false);
			m.put("message", e.getMessage());
			e.printStackTrace();			
		}		
		return m;
	}
}
