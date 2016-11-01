package com.chitra.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.dao.UserProfileDao;
import com.chitra.school.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
	UserProfileDao dao;
	public List<UserProfile> findAll() {
		return dao.findAll();
	}

	public UserProfile findByType(String type) {
		return dao.findByType(type);
	}

	public UserProfile findByid(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
