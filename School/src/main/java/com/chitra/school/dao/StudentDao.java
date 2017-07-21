package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.Memo;
import com.chitra.school.entities.Student;


public interface StudentDao {
	
	List<Student> findStudent(String id, String name, String classroom);
	
	List<Student> findAll(String id, int maxResult, int firstResult);
	long totalRecord(String id);
	
	List<Student> findStudentByCLSroomID(String clsroomId, int maxResult, int pageCount);
	long totalStudentByCLSroomId(String clsroomId);
	
	void update(Student student, Memo memo);
	List findAll(int userId, String firstName, String lastName, String searchName, int maxResult, int firstResult);
	long countRecordListl(int userId, String firstName, String lastName, String searchName);
	
	void save(Student student, Memo memo);
	Student findById(String id);
	Student findByFirstName(String firstName);
	


}
