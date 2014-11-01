package edu.irabank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;



// Import the related DTO and services
// TODO: add DTO and services 











import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean; 
import edu.irabank.service.UserService;


	@Controller
	@SessionAttributes
//	@RequestMapping("newuser")
	public class UserRegistrationController 
	{
		
		@Autowired
		private UserService userService;  // Autowire the User Service
		
		// GET Method of Register - shows the page.
		@RequestMapping(value="/register", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the registerUser.jsp
			return "/ExternalUsers/registerUser";
		}
		
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="/register", method = RequestMethod.POST)
		public ModelAndView createNewUser(@ModelAttribute("userRegistrationFormBean") @Valid UserRegistrationFormBean userRegistrationFormBean,  BindingResult result, ModelMap model, SessionStatus status) {
			
			// Trying arraylist option for displaying errors.
			
			ArrayList<String> errorCode = new ArrayList<String>();
	
			// use the Form Elements values from Registration form and check for the validations
			
			// Case 1: JSR303 validation. Checks for Hibernate related form issues.
			
			if (result.hasErrors()){
				System.out.println("comes in form errors of register");
				model.addAttribute("userRegistrationStatus", "Please fill the necessary fields and try again");
				model.addAttribute("userRegistrationFormBean",userRegistrationFormBean);
				return new ModelAndView( "/ExternalUsers/registerUser",model);
			}
			
			// Case 2 : Server-side validation : Start the validation before calling the Add User service.
	
			Boolean serverValidationError = false;
			
			// Check for all the UserRegistrationFormBean values.
			if(userRegistrationFormBean.getUserName()==null || !userRegistrationFormBean.getUserName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the username. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			if(userRegistrationFormBean.getFirstName()==null || !userRegistrationFormBean.getFirstName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the First Name. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getLastName()==null || !userRegistrationFormBean.getLastName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Last Name. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getEmailId()==null || !userRegistrationFormBean.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			{
				errorCode.add("Please check the Email ID. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			if(userRegistrationFormBean.getPassword()==null || !userRegistrationFormBean.getPassword().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Password. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getContactNum()==null || !userRegistrationFormBean.getContactNum().matches("^[0-9 -]+$"))
			{
				errorCode.add("Please check the Phone. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getDob()==null) // write proper regex here
			{
				errorCode.add("Please check the Date of Birth. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getSecQue1()==null || !userRegistrationFormBean.getSecQue1().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Security Que 1. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getSecAns1()==null || !userRegistrationFormBean.getSecAns1().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Security Ans 1. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			if(userRegistrationFormBean.getSecQue2()==null || !userRegistrationFormBean.getSecQue2().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Security Que 2. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}

			if(userRegistrationFormBean.getSecAns2()==null || !userRegistrationFormBean.getSecAns1().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Security Ans 2. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			if(userRegistrationFormBean.getAddress()==null || !userRegistrationFormBean.getAddress().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Address Field. It is not in expected format.");
				model.addAttribute("userRegistrationStatus",errorCode);
				serverValidationError = true;
			}
			
			// Go back to register page with these validation errors.
			if(serverValidationError){
				return new ModelAndView("/ExternalUsers/registerUser", model); // return back to register
			}
			

			// Special Error Message : User Already Exists.	
			if (userService.getUserDTOByUsername(userRegistrationFormBean.getUserName()) !=null){
				System.out.println("User exists ");
				model.addAttribute("userRegistrationStatus", "This user already exists. Please try again with another username/email");
				model.addAttribute("userRegistrationFormBean",userRegistrationFormBean);
				return new ModelAndView("/ExternalUsers/registerUser", model);	
			}
			
			
			
		
				
				if(!serverValidationError)
				{
					// Call the User Registration service.
					Boolean userCreationStatus = userService.addNewUser(userRegistrationFormBean);
					
					if(userCreationStatus == false)
					{
						model.addAttribute("userRegistrationStatus","There seems to be some issues. Please try again later.");
						return new ModelAndView("/ExternalUsers/registerUser", model); // return back to register
					
					}
					else
					{
						model.addAttribute("userRegistrationStatus", "User Registered successfully. Please login");
						model.addAttribute("userName", userRegistrationFormBean.getUserName());
						return new ModelAndView("/securedLogin/login", model);
					}
			   }
		
				return new ModelAndView("/securedLogin/login", model);
	
			
		}
		
	
}
	 
	 
	
