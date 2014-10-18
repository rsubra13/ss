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
			return "/ExternalUsers/registerUser";
		}
		
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="register", method = RequestMethod.POST)
		public ModelAndView createNewUser(@ModelAttribute("userRegistrationFormBean") UserRegistrationFormBean userRegistrationFormBean,  BindingResult result, ModelMap model, SessionStatus status) {
			// use the Form Elements values from Registration form
			// Case 1: if the User Already exists
			if (userService.getUserDTOByUsername(userRegistrationFormBean.getUserName()) !=null){
				model.addAttribute("userRegistrationStatus", "This username already exists. Please try again with another username");
				model.addAttribute("userRegistrationFormBean",userRegistrationFormBean);
				return new ModelAndView("ExternalUsers/registerUser", model);
				
			}
			//Case 2: User doesn't exist.
			else{
				// add the user
				Boolean userCreationStatus = userService.addNewUser(userRegistrationFormBean);
				System.out.println("userCreationStatus is :" + userCreationStatus);
				if(userCreationStatus){
					model.addAttribute("userRegistrationStatus", "User Registered successfully. Please login");
					return new ModelAndView("index", model); // Login page
				}
				else{
					model.addAttribute("userRegistrationStatus", "There seems to be some connection issues. Please try again");
					return new ModelAndView("ExternalUsers/registerUser", model); // return back to register
				}
				
				
			}
		}
		
	
}
	 
	 
	
