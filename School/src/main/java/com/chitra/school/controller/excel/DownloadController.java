package com.chitra.school.controller.excel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chitra.school.dao.StudentDao;
import com.chitra.school.entities.Student;

@Controller
@RequestMapping("/dashboard")
public class DownloadController {
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/people/school_1002_0301_download")
	public ModelAndView downloadStudent(
			@RequestParam("srcStudentId") String id 
			)throws Exception{
		
		long totalRecord =  studentDao.totalRecord(id);
		int maxResult = (int)totalRecord;
		List<Student> students = studentDao.findAll(id, 0, maxResult);
		
		
		return new ModelAndView("school_1002_0301_download","students", students);
	}

}
