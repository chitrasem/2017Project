package com.chitra.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chitra.school.model.Book;
import com.chitra.school.model.User;
import com.chitra.school.service.UserService;
import com.chitra.school.utils.SSOIdUtil;

@Controller
public class IndexController {

	@Autowired
	UserService userService;
	SSOIdUtil sSOIdUtil = new SSOIdUtil();

    public User getUser(){
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		return user;
    }
    
	/*New Edition
	 * 
	 * 
	 */
	
	@RequestMapping(value="/")
	public ModelAndView indexPage(){		
		return new ModelAndView("redirect:school_1001_0101.act");		
	}
	@RequestMapping(value="school_1001_0101.act")
	public String showDashboardForm(Model m){
		
		m.addAttribute("user", getUser());		
		return "dashboard/school_1001_0101_view";
	}
	
	@RequestMapping(value="/school_1002_0101.act")
	public String showUsersForm(Model m){
		m.addAttribute("user", getUser());		
		User user = getUser();
		System.out.println(user.getFirstName());
		return "dashboard/school_1002_0101_view";
	}
	@RequestMapping(value="/school_1002_0201.act")
	public String showTeachersForm(Model m){
		m.addAttribute("user", getUser());		
		return "dashboard/school_1002_0201_view";
	}
	/**
	 * List all Students
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/school_1002_0301.act")
	public String showStudentsForm(Model m){
		
		m.addAttribute("user", getUser());		
		return "dashboard/school_1002_0301_view";
	}
	/**
	 * Add new Students form
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/school_1002_0302.act")
	public String addStudentForm(Model m){
		
		m.addAttribute("user", getUser());		
		return "dashboard/school_1002_0302_view";
	}
	
	
	
	//End New Edition
	
	
	
	@RequestMapping(value="/uploading")
	public String uploadingFile(){
		return "/upload";
	}
	/**
	 * Handle request to download an Excel document 
	 */
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		// create some sample data
		List<Book> listBooks = new ArrayList<Book>();
		listBooks.add(new Book("Effective Java", "Joshua Bloch", "0321356683",
				"May 28, 2008", 38.11F));
		listBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates",
				"0596009208", "February 9, 2005", 30.80F));
		listBooks.add(new Book("Java Generics and Collections",
				"Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
		listBooks.add(new Book("Thinking in Java", "Bruce Eckel", "0596527756",
				"February 20, 2006", 43.97F));
		listBooks.add(new Book("Spring in Action", "Craig Walls", "1935182358",
				"June 29, 2011", 31.98F));

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("excelView", "listBooks", listBooks);
	}
}
