package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.entities.UserProfile;
import com.chitra.school.service.UserProfileService;

@RequestMapping("/dashboard")
@RestController
public class UserProfileRestController {
	@Autowired
	private UserProfileService profileService;
	
	@RequestMapping(value="/service/userProfile", method = RequestMethod.GET)
	public Map<String, Object> userProfile(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<UserProfile> userProfiles = profileService.findAll();
			//userProfiles.clear();
			if(userProfiles==null || userProfiles.isEmpty()){
				map.put("MESSAGE", "Empty!");
			}else{
				map.put("LIST", userProfiles);
				map.put("MESSAGE", "Exist");
			}
		}catch(Exception e){
			map.put("MESSAGE", e.getMessage());
		}
		
		return map;
	}

}
