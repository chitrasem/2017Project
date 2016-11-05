package com.chitra.school.service;

import java.util.List;

import com.chitra.school.model.Student;

public interface StudentService {
	List<Student> findAll();
	List<Student> findAll(int userId, String firstName, String lastName, String searchName, int maxResult, int firstResult);
	long countRecordListl(int userId, String firstName, String lastName, String searchName);
	void save(Student student);
	Student findById(String id);
	Student findByFirstName(String firstName);

}
