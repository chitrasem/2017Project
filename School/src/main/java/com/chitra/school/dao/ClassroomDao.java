package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Classroom;

public interface ClassroomDao {
	
	void save(Classroom classroom);
	Classroom findClassroomById(String id);
	List<Classroom> findAllClassrooms(String id);
	void updateClassroom(Classroom classroom);

}
