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

import edu.irabank.dto.UsersDTO;
import edu.irabank.service.*;


	@Controller
	public class LoginController 
	{
		
		@Autowired
		private UserService userService; 

		
		@RequestMapping(value="/Welcome", method=RequestMethod.POST)
	    public ModelAndView userLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord, HttpSession sessionID)
	    {
			boolean isFormValidationSucccess = validateLoginFields(userName, passWord);
			System.out.println("isFormValidatation" + isFormValidationSucccess);
			if(isFormValidationSucccess == true)
			{
				boolean isLoginSuccess = userService.validateUser(userName, passWord);
				System.out.println("isLoginSuccess" + isLoginSuccess);
				if(isLoginSuccess == true)
				{
					// setting session variables if the Login is successful
					sessionID.setAttribute("userName", userName);
					UsersDTO uDTO = userService.getUserDTO(userName);
					sessionID.setAttribute("userId", uDTO.getUserId());
					return new ModelAndView("/Home");
				}
			}
			return new ModelAndView("/index").addObject("loginError", "Invalid UserName or Password!");
		}
		
		public boolean validateLoginFields(String userName, String password)
		{
			
			if((userName.isEmpty()) || (password.isEmpty()))
			{
				return false;
			}
			return true;
		}
}
	 
	 
	
