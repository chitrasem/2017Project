package com.chitra.school.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.chitra.school.entities.User;
import com.chitra.school.service.UserService;

public class SSOIdUtil {

	@Autowired
	UserService userService;
	User user;

	public User getUser() {
		User user = userService.findBySso(this.getPrincipal());
		return user;
	}

	public String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
