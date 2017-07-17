package com.chitra.school.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final  class StringUtils {
	public static String getSystemDate(){
		// Get Current Date and Time		
		Date date = new Date(System.currentTimeMillis());		
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");		
		return df.format(date);
		
	}
	public static String getStrDate() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date() );
	}
    public	static  String getYearMonthDay(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());		
	}
	public static String getPrincipal(){
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
