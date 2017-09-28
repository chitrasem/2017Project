package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.Grade;

public interface GradeDao {
	List<Grade> getGrade();
	void saveGrade(Grade grade);
}
