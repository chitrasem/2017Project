package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Memo;
import com.chitra.school.model.Student;


public interface StudentDao {
	
	List<Student> findAll();
	void update(Student student, Memo memo);
	List findAll(int userId, String firstName, String lastName, String searchName, int maxResult, int firstResult);
	long countRecordListl(int userId, String firstName, String lastName, String searchName);
	
	void save(Student student, Memo memo);
	Student findById(String id);
	Student findByFirstName(String firstName);

}
