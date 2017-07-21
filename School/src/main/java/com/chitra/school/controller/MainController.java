package com.chitra.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chitra.school.entities.User;
import com.chitra.school.entities.UserProfile;
import com.chitra.school.service.UserProfileService;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;
 
@Controller
public class MainController { 
	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;
	SSOIdUtil sSOIdUtil = new SSOIdUtil();
	
	@RequestMapping(value="/test/modal")
	public String testModalPage(Model m){			
		User user =  userService.findBySso(sSOIdUtil.getPrincipal());
		m.addAttribute("user", user);
		return "/dashboard/testModal";
		
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */

	
	@RequestMapping(value="/dashboard/contact", method = RequestMethod.GET)
	public String showContactList(Model m){			
		User user =  userService.findBySso(sSOIdUtil.getPrincipal());
		m.addAttribute("user", user);
		
		return "/dashboard/contact";
		
	}
	
	@RequestMapping(value="/dashboard/profile", method = RequestMethod.GET)
	public String showUserProfile(Model m){	
		
		User user =  userService.findBySso(sSOIdUtil.getPrincipal());	
		 
		
		//m.addAttribute("user", sSOIdUtil.getUser());
		m.addAttribute("user", user);
		
		return "/dashboard/profile";
		
	}
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
     
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getUser());
        return "/accessDenied";
    }
    
    
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/newUser" , method = RequestMethod.GET)
    public String newRegistration(ModelMap model){
    	User user = new User();
    	model.addAttribute("user",user);
    	model.addAttribute("roles",initializeProfiles());
    	return "newuser"; 
    }
    
    /**
     * 
     * @param user
     * @param result
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
    		BindingResult result, ModelMap model){
    	if(result.hasErrors()){
    		System.out.println("There are errors");
    		return "newuser";    		
    	}
    	userService.save(user);
    	//Checking profile
    	if(user.getUserProfiles()!=null){
    		for(UserProfile profile : user.getUserProfiles()){
    			System.out.println("Profile"+ profile.getType());;
    		}
    	}
    	model.addAttribute("success", "User" + user.getFirstName());
    	
    	return "registerationsuccess";
    }
    public User getUser(){
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		return user;
    }
    
    /**
     * 
     * @return
     */
    @ModelAttribute("role")
    public List<UserProfile> initializeProfiles(){
    	return userProfileService.findAll();
    }
    
}