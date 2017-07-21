package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.StudentDao;
import com.chitra.school.entities.Course;
import com.chitra.school.entities.Memo;
import com.chitra.school.entities.Student;
import com.chitra.school.entities.User;
import com.chitra.school.service.MemoService;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/dashboard/people")
public class StudentRest {
	
	@Autowired
	UserService userService;
	@Autowired 
	MemoService memoService;
	SSOIdUtil ssoIdUtil = new SSOIdUtil();
	
	@Autowired
	StudentDao studentDao;

	@RequestMapping(value = "/school_1002_0101_r001.chitra" , method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> getUsers(SSOIdUtil ssoIdUtil) {
		Map<Object, Object> map = new HashMap<Object, Object>();		
		List<User> users = userService.findAllUsers();		
		map.put("UserRec",users);
		map.put("success", true);

		return map;
	}
	@RequestMapping(value="/school_1002_0301_r001.chitra", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> listStudent(
			
			@RequestParam("numberOfRecord") int numberOfRecord,
			@RequestParam("pageCount") int pageCount,
			@RequestParam("id") String id
			
			)throws Exception{
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Student> students = studentDao.findAll(id, numberOfRecord, pageCount);
		long totalStudentRec = studentDao.totalRecord(id);
		try{
			map.put("totalStudent", totalStudentRec);
			map.put("studentRec", students);
			map.put("success", true);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}
	@RequestMapping(value="/school_1002_0302_r001.chitra/{studentId}",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> getStudent(@PathVariable("studentId") String studentId)throws Exception{
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		try{
			Student student = studentDao.findById(studentId);		
			List<Memo> memoes = memoService.listMemoByStudentId(studentId);
			map.put("memoRec", memoes);
			map.put("studentRec", student);
			map.put("success", true);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		
		return map;
	}
	@RequestMapping(value="/school_1002_0302_r002.chitra",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> findStudentsByCLSRoomId(
			@RequestParam("clsroomId") String clsroomId,
			@RequestParam("numberOfRecord") int numberOfRecord,
			@RequestParam("pageCount") int pageCount
			)throws Exception{
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		try{
			List<Student> students = studentDao.findStudentByCLSroomID(clsroomId, numberOfRecord, pageCount);
			long totalRecord = studentDao.totalStudentByCLSroomId(clsroomId);
			map.put("totalStudent", totalRecord);
			map.put("studentRec", students);
			map.put("SUCCESS", true);
		}catch(Exception e){
			map.put("SUCCESS", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/school_1002_0302_c001.chitra", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Object, Object> addStudents( 			
			@RequestBody String str
			)throws Exception{
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(str);	
		
	
		try{
			
			Student student = mapper.convertValue(node.get("student"), Student.class);		
			Memo memo = mapper.convertValue(node.get("memo"), Memo.class);
			//Course course = mapper.convertValue(node.get("course"), Course.class);
			
			
			User user = userService.findBySso(ssoIdUtil.getPrincipal());
			
			student.setRegisterPerson(user.getSsoId());	
			//student.setCourse(course);
			
			
			memo.setRegisterPerson(user.getSsoId());		
			memo.setStudent(student);		
			
			studentDao.save(student, memo);	
			map.put("firstname", student.getFirstName());
			map.put("success", true);		
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}		
		
		return map;
	}

	@ResponseBody
	@RequestMapping(value="/school_1002_0302_u001.chitra", method=RequestMethod.POST)
	public Map<Object, Object> updateStudents( 			
			@RequestBody String str
			)throws Exception{
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(str);

		Student student = mapper.convertValue(node.get("student"), Student.class);		
		Memo memo = mapper.convertValue(node.get("memo"), Memo.class);	
			
		
		try{
			student.setChangePerson(ssoIdUtil.getPrincipal());	
			memo.setRegisterPerson(ssoIdUtil.getPrincipal());		
			memo.setStudent(student);	
			studentDao.update(student, memo);
			
			map.put("success", true);
			
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		return map;
		
	}

}
