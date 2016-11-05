package com.chitra.school.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.school.dao.StaffDao;
import com.chitra.school.model.Staff;
import com.chitra.school.utils.DateUtils;

@RestController
@RequestMapping("/service")
public class StaffRest {
	
	@Autowired
	StaffDao staffDao;
	
	@RequestMapping(value="/school_1002_0202_r001.chitra/{staffId}" , method = RequestMethod.GET)
	public Map<String, Object> getStaff(@PathVariable("staffId") String staffId			
			){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			Staff staff = staffDao.findStaffByID(staffId);
			map.put("success", true);
			map.put("staff", staff);			
		}catch(Exception e){
			e.printStackTrace();
			map.put("message", e.getMessage());
		}
		
		return map;
	}

	@RequestMapping(value="/school_1002_0201_r001.chitra" , method = RequestMethod.GET)
	public Map<String, Object> listStaffs(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			List<Staff> staffs = staffDao.findAllStaff();
			map.put("success", true);
			map.put("staffRec", staffs);
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		return map;
		
	}
	@RequestMapping(value="save.chitra")
	public Map<String, Object> saveStaff(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		DateUtils utils = new DateUtils();
		
		Staff staff = new Staff();
		staff.setFirstName("Chitra");
		staff.setLastName("Sem");
		staff.setKmFirstName("ABC");
		staff.setKmLastName("GHIJK");
		staff.setGender("M");
		staff.setBirthDate(utils.getYearMonthDay());
		
		try{
			staffDao.saveStaff(staff);
			map.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		
		return map;
		
	}

}
