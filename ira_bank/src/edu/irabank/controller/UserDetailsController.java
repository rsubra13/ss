package edu.irabank.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
					model.put("user", new UserDTO());
					model.put("usersList", userService.listUsers());
//					/System.out.println("in controller GET : ");
					
					return "/ExternalUsers/listUsers";
				}
		
			
				 // Edit User
				 @RequestMapping("/get/{userId}")
			       public ModelAndView getUser(@ModelAttribute("user") UserDTO user, @PathVariable Integer userId, Map<String, Object> map, ModelMap model) {

			              //UserDTO userDTO = new UserDTO();
			              System.out.println("userId : 50" + userId);
			              UserDTO userDTO = userService.getUserDTOByUserId(userId);
			              System.out.println("comes here : 52 " + userDTO);
						  model.addAttribute("userdetailsGetStatus", "Cool, got it!");
						  model.addAttribute("user",userDTO);
			              System.out.println("55: userDTO : " + userDTO.getFirstName());
			              //map.put("user", user);	
			    		  return new ModelAndView("/InternalUsers/userDetailsForm", model);
			            
			       }
				 
				 // Update the existing user.
				 @RequestMapping(value = "/save", method = RequestMethod.POST)
					public String updateUser(@ModelAttribute("user") UserDTO userDTO,
							BindingResult result,ModelMap model) {
						
						userService.updateUserDetails(userDTO);
						model.put("user", new UserDTO());
						model.put("usersList", userService.listUsers());
						System.out.println("in update users GET : ");
					
						return "/ExternalUsers/listUsers";
					}

				 
				  // Delete User.
					@RequestMapping("/delete/{userId}")
					public String deleteUser(@PathVariable("userId") Integer userId) {

						userService.deleteUser(userId);
						return "/ExternalUsers/listUsers";
					}

		
		
		}
	 
	 
	
