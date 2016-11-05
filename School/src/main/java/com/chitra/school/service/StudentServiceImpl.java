package com.chitra.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.dao.StudentDao;
import com.chitra.school.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{	
	@Autowired
	StudentDao studentDao;

	public List<Student> findAll(int userId, String firstName, String lastName, String searchName, int maxResults, int firstResults) {
		return studentDao.findAll(userId, firstName, lastName, searchName, maxResults, firstResults);
	}

	public void save(Student student) {
		studentDao.save(student);
		
	}

	public Student findById(String id) {
		return studentDao.findById(id);
	}

	public Student findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return studentDao.findByFirstName(firstName);
	}

	public long countRecordListl(int userId, String firstName, String lastName, String searchName) {
		
		return studentDao.countRecordListl(userId, firstName, lastName, searchName);
	}

	public List<Student> findAll() {
		return studentDao.findAll();
	}


}
