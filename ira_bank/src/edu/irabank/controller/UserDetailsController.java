package edu.irabank.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;
import edu.irabank.service.UserService;


	@Controller
	public class UserDetailsController 
	{
		
		@Autowired
		private UserService userService; // change it to the user details related service. 

		
		// GET Method of Listing Users - shows the page.
				@RequestMapping(value="/listUsers", method = RequestMethod.GET)
				public String listAllUsers(ModelMap model) {
					// redirect to the listUsers.jsp

					model.put("UserDTO", new UserDTO());
					model.put("usersList", userService.listUsers());
					System.out.println("in controller GET : ");
					
					return "/ExternalUsers/listUsers";
				}
		
				
				// POST Method of Register - comes back after the submit of User Details Form.
				@RequestMapping(value="/listUsers", method = RequestMethod.POST)
				public ModelAndView createNewUser(Map<String, Object> map, SessionStatus status) {
					
					// use the Form Elements values from Registration form
					// Case 1: if the User Already exists
					
					map.put("user", new UserDTO());
					map.put("usersList", userService.listUsers());
					System.out.println("in controller : ");
					
					return null;
					
				}
		
		
		}
	 
	 
	
