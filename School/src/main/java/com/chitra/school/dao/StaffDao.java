package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.Staff;

public interface StaffDao {
	
	void saveStaff(Staff staff);
	Staff findStaffByID(String id);
	List<Staff> findAllStaff();

}
