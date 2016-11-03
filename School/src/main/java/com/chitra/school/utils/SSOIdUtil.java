package com.chitra.school.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SSOIdUtil {
	
	/*@Autowired
	UserService userService;
	
	User user;
	
	public User getUser(){
		
		user = userService.findBySso(getPrincipal());
		
		return user;
		
	}*/
	
	public String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName; 
    }

}
