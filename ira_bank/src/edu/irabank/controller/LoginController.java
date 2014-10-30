
package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

		public static final Logger logger = Logger.getLogger(LoginController.class);
		// GET Method of Login Forms
		@RequestMapping(value="/Welcome", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the Welcome.jsp
			System.out.println("comes here");
			return "/Welcome";
		}

			/*Login Method - GET*/
		@RequestMapping(value="login", method = RequestMethod.GET)
		public String userLogin(ModelMap model) {
			/*redirect to login.jsp*/
			logger.debug("Comes in Login controller");
			System.out.println("comes here in Login Controller");
			return "/securedLogin/login";
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
					return new ModelAndView("/login",model);
					
				}
			}
			return new ModelAndView("/login").addObject("loginError", "Invalid UserName or Password!");
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
		
		/*Logout - GET*/
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String userLogout(ModelMap model) {
			return "/securedLogin/login";
		}
		
		/*LoginFailed - wrong password or username*/
		@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
		public String userLoginError(ModelMap model) {
			model.addAttribute("error", "true");
			return "/securedLogin/login";
	 
		}
        // New Home page
		@RequestMapping(value="/home", method = RequestMethod.GET)
		public ModelAndView redirectToHome(ModelMap model, HttpSession sessionID) {
			logger.debug("Comes in Common Home");
			System.out.println("are u coming here : 98");
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String userName = user.getUsername(); //get logged in username
            
            // Setting session variables
            sessionID.setAttribute("userName", userName);
			UserDTO uDTO = userService.getUserDTOByUsername(userName);
			
			sessionID.setAttribute("userId", uDTO.getUserId());
			model.addAttribute("userName", userName);
			return new ModelAndView("/common/commonHome",model);
		    
  	}
		
		@RequestMapping(value="/home", method = RequestMethod.POST)
		public String redirectToHomePost(ModelMap model, HttpSession session) {
			logger.debug("Comes in Common Home - POST");
			System.out.println("are u coming here : 98");
		    return "/common/commonHome";
		}
	
		
		/*Access Denied*/
		@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
		public String userAccessDenied(ModelMap model) {
			/*redirect to accessDenied.jsp*/
			return "/common/accessDenied";
		}
		
}
	 
	 
	
