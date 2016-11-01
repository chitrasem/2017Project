package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Student;
import com.chitra.school.model.User;

public interface StudentDao {
	
	List<Student> findAll();
	
	List findAll(int userId, String firstName, String lastName, String searchName, int maxResult, int firstResult);
	long countRecordListl(int userId, String firstName, String lastName, String searchName);
	
	void save(Student student);
	Student findById(int id);
	Student findByFirstName(String firstName);

}
