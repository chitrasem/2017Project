package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Cources;

public interface CourceDao {
	
	void save(Cources classroom);
	Cources findClassroomById(String id);
	List<Cources> findAllClassrooms();
	void updateClassroom(Cources classroom);

}
