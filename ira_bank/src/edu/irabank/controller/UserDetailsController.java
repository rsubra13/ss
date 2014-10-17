package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.UserDTO;
import edu.irabank.service.UserService;


	@Controller
	public class UserDetailsController 
	{
		
		@Autowired
		private UserService userService; // change it to the user details related service. 

		
		}
	 
	 
	
