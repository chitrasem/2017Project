package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
    
    void save(User user);
    
    List<User> findAllUsers();
    
    void deleteUserById(int id);
     
}
