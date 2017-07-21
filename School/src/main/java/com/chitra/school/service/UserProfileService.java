package com.chitra.school.service;

import java.util.List;

import com.chitra.school.entities.UserProfile;

public interface UserProfileService {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByid(int id);

}
