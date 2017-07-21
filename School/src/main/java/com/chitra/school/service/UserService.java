package com.chitra.school.service;

import java.util.List;

import com.chitra.school.entities.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    void save(User user);
    
    List<User> findAllUsers();
    
    void deleteUserById(int id);
     
}
