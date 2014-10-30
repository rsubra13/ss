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
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;



// Import the related DTO and services
// TODO: add DTO and services 


//DTO to be done??
import edu.irabank.dto.UserDTO;
import edu.irabank.form.IssueFormBean; 
import edu.irabank.service.RequestService;


	@Controller
	@SessionAttributes
//	@RequestMapping("newuser")
	public class RequestController 
	{
		
		@Autowired
		private RequestService requestService;  // Autowire the User Service
		
		
		// GET Method of Register - shows the page.
		//Commenting next part, where to keep issues link
		@RequestMapping(value="/ExternalUsers/Issues", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the Issues.jsp
			return "/ExternalUsers/Issues";
			//return "pages/ExternalUsers/Issues";
		}
		
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="/ExternalUsers/Issues", method = RequestMethod.POST)
		
		public ModelAndView createNewRequest(@ModelAttribute("issueFormBean") IssueFormBean issueFormBean,  BindingResult result, ModelMap model, SessionStatus status) {
			// use the Form Elements values from Issue form
			//Calling add new issue method of issueFormBean
			Boolean issueCreationStatus = requestService.addNewIssue(issueFormBean);
			System.out.println("issueCreationStatus is :" + issueCreationStatus);
				if(issueCreationStatus){
				 model.addAttribute("issueCreationStatus", "Issue submitted successfully");
//					model.addAttribute("userName", userRegistrationFormBean.getUserName());
//					System.out.println("63 : comes till here");
//					//return new ModelAndView(new RedirectView("Welcome"));
				return new ModelAndView("/ExternalUsers/Issues", model); // Login page
				}
			    else{
				model.addAttribute("issueCreationStatus", "There seems to be some connection issues. Please try again");
				return new ModelAndView("/ExternalUsers/Issues", model); // return back to issues page				
				}
//				
//				
//			}
//		}
//		
//	
//}
	 
		}
	}
	