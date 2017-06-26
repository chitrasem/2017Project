package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.PaymentDao;
import com.chitra.school.model.Payment;
import com.chitra.school.utils.SSOIdUtil;

@RestController
@RequestMapping("/dashboard/payment")
public class PaymentRest {
	SSOIdUtil ssoIdUtil = new SSOIdUtil();
	@Autowired
	PaymentDao dao;

	@RequestMapping(value = "/school_1005_0102_c001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> save(){
		Map<Object, Object> m = new HashMap<Object, Object>();
		Payment p = new Payment();
		p.setAmountKm("1000");
		p.setAmountUs("1000");
		p.setDescription("Good");
		
		try{
			dao.save(p);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return m;
	}
	@RequestMapping(value = "/school_1005_0102_r001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> list(){
		Map<Object, Object> m = new HashMap<Object, Object>();
		try{
			List<Payment> list = dao.list();
			m.put("PAYMENT_REC", list);
			m.put("message", "success");			
		}catch(Exception e){
			m.put("message", "failed");
			e.printStackTrace();
		}
		
		return m;
	}
}
