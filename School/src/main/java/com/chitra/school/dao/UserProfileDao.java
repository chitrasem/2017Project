package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.UserProfile;

public interface UserProfileDao {
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	

}
