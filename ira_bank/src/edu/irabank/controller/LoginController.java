package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.UserDTO;
import edu.irabank.service.UserService;


	@Controller
	public class LoginController 
	{
		
		@Autowired
		private UserService userService; 

		
		// GET Method of Login Form
		@RequestMapping(value="/Welcome", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the Welcome.jsp
			System.out.println("comes here");
			return "/Welcome";
		}
		
		// Post Method after submitting user details in Login Form
		@RequestMapping(value="/Welcome", method=RequestMethod.POST)
	    public ModelAndView userLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord,ModelMap model, SessionStatus status, HttpSession sessionID)
	    {
			//TODO validateLoginFields to be made proper.
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
					UserDTO uDTO = userService.getUserDTOByUsername(userName);
					sessionID.setAttribute("userId", uDTO.getUserId());
					model.addAttribute("userName", userName);
					return new ModelAndView("/Home",model);
					
				}
			}
			return new ModelAndView("/index").addObject("loginError", "Invalid UserName or Password!");
		}
		
		// Not a proper validation.
		public boolean validateLoginFields(String userName, String password)
		{
			
			if((userName.isEmpty()) || (password.isEmpty()))
			{
				return false;
			}
			return true;
		}
}
	 
	 
	
