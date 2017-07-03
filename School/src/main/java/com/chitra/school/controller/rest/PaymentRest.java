package com.chitra.school.controller.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.Balance;
import com.chitra.school.dao.PaymentDao;
import com.chitra.school.model.Payment;
import com.chitra.school.model.Student;
import com.chitra.school.utils.SSOIdUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/dashboard/payment")
public class PaymentRest {
	SSOIdUtil ssoIdUtil = new SSOIdUtil();
	@Autowired
	PaymentDao dao;

	@RequestMapping(value = "/school_1005_0102_c001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> save(
			@RequestBody String str
			) throws JsonProcessingException, IOException{
		Map<Object, Object> m = new HashMap<Object, Object>();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(str);	
		
		Payment payment = mapper.convertValue(node.get("payment"), Payment.class);		
		try{
			dao.save(payment);			
			m.put("success", true);
		}catch(Exception e){	
			m.put("success", false);
			m.put("message", e.getMessage());
			e.printStackTrace();
		}		
		return m;
	}
	@RequestMapping(value = "/school_1005_0102_r001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> listBalance(){
		Map<Object, Object> m = new HashMap<Object, Object>();
		try{
			List<Balance> list = dao.curBalanceList();
			m.put("BALANCE_REC", list);
			m.put("success", true);			
		}catch(Exception e){
			m.put("success", false);
			e.printStackTrace();
		}
		
		return m;
	}
	@RequestMapping(value = "/school_1005_0102_r002.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
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
