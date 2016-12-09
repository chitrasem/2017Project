package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Course;

public interface CourseDao {
	
	void save(Course course);
	Course findCourseById(String id);
	List<Course> findAllCourses();
	void updateCourse(Course course);

}
