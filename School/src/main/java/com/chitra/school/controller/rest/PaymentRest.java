package com.chitra.school.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.Balance;
import com.chitra.school.dao.PaymentDao;
import com.chitra.school.dao.StudentDao;
import com.chitra.school.list.PaymentDtlRec;
import com.chitra.school.model.Payment;
import com.chitra.school.model.PaymentDetail;
import com.chitra.school.model.Student;
import com.chitra.school.utils.SSOIdUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/dashboard/payment")
public class PaymentRest {
	SSOIdUtil ssoIdUtil = new SSOIdUtil();
	@Autowired
	PaymentDao dao;
	@Autowired
	StudentDao stuDao;

	@RequestMapping(value = "/school_1005_0102_c001.chitra" , method = RequestMethod.POST ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> save(
			@RequestBody String str
			) throws JsonProcessingException, IOException{
		Map<Object, Object> m = new HashMap<Object, Object>();

		ObjectMapper mapper = new ObjectMapper();		
		try{
			JsonNode node = mapper.readTree(str);	
			Payment payment = mapper.convertValue(node.get("payment"), Payment.class);	
			Student student = mapper.convertValue(node.get("student"), Student.class);	
			ArrayNode arr = (ArrayNode) node.get("paymentDtlRec");			
			ObjectReader reader = mapper.readerFor(new TypeReference<List<PaymentDetail>>() {
			});
			List<PaymentDetail> payDtlRec = reader.readValue(arr);
			dao.save(payment, payDtlRec, student);
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
	@RequestMapping(value = "/school_1005_0102_r003.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> listStudent(){
		Map<Object, Object> m = new HashMap<Object, Object>();
		try{
			List<Student> list = stuDao.findStudent("", "", "");
			m.put("STUDENT_REC", list);
			m.put("success", true);			
		}catch(Exception e){
			m.put("success", false);
			e.printStackTrace();
		}
		
		return m;
	}
	
}
