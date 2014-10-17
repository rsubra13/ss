package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;



// Import the related DTO and services
// TODO: add DTO and services 


import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean; 
import edu.irabank.service.UserService;


	@Controller
	@SessionAttributes
	@RequestMapping("newuser")
	public class UserRegistrationController 
	{
		
		@Autowired
		private UserService userService;  // Autowire the User Service
		
		// GET Method of Register - shows the page.
		@RequestMapping(value="register", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the registerUser.jsp
			return "ExternalUsers/registerUser";
		}
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="register", method = RequestMethod.POST)
		public String createNewUser(@ModelAttribute("userRegistrationFormBean") UserRegistrationFormBean userRegistrationFormBean,  BindingResult result, ModelMap model, SessionStatus status) {
			// redirect to the registerUser.jsp
			
			return "ExternalUsers/registerUser";
		}
		
	
}
	 
	 
	
