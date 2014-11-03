//package edu.irabank.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import java.util.UUID;
//
//import java.util.Random;
//
//import edu.irabank.dao.UserDAO;
//import edu.irabank.dto.UserDTO;
//import edu.irabank.form.ForgotPasswordFormBean;
//import edu.irabank.service.UserService;
//
//@Controller
//public class ForgotpasswordController {
//	
//	 @Autowired
//	 private JavaMailSender mailSender; 
//	 
//	 @Autowired
//	 private UserService userService; 
//	 
//	@RequestMapping(value="Forgot", method = RequestMethod.GET)
//	public String forgotpasswordform(ModelMap model) {
//		// redirect to the registerUser.jsp
//		return "/ForgotPassword";
//	}
//	
//	
//	   
//	    @RequestMapping(value="Forgot", method = RequestMethod.POST)
//	    public  ModelAndView doSendEmail(@ModelAttribute("forgotPasswordFormBean") ForgotPasswordFormBean forgotPasswordFormBean ,BindingResult result, ModelMap model) 
//	    {
//	    	//System.out.println("comes in forgot controller ::" + forgotPasswordFormBean.getEmailId());
//	    	
//	    	if(userService.getUserDTOByEmailId(forgotPasswordFormBean.getEmailId()) != null)
//	    	{
//	    		
//	    		try
//	    		{
//				    	// takes input from e-mail form
//				    String  recipientAddress =forgotPasswordFormBean.getEmailId();
//				    UserDTO retrievedDTO = userService.getUserDTOByEmailId(recipientAddress);
//				String secAns1=forgotPasswordFormBean.getSecAns1().trim();
//				String secAns2=forgotPasswordFormBean.getSecAns2().trim();
//				    if(secAns1.equals(retrievedDTO.getSecAns1())&&secAns2.equals(retrievedDTO.getSecAns2())&&forgotPasswordFormBean.getDob().equals(retrievedDTO.getDob()))
//				    {
//				    
//				  
//				    UUID idOne = UUID.randomUUID();
//				    String OTP= String.valueOf(idOne);
//				    
//				    //System.out.println("retrievedDTO ::" +retrievedDTO.getEmailId() + retrievedDTO.getFirstName());
//				    retrievedDTO.setOtp(OTP);
//				    Boolean storeotp = userService.storeotp(retrievedDTO);
//				    
//				        // creates a simple e-mail object
//				        SimpleMailMessage email = new SimpleMailMessage();
//				        email.setTo(recipientAddress);
//				        email.setSubject("One Time Password");
//				        email.setText("The otp for the account is "+OTP);
//				         
//				        // sends the e-mail
//				        mailSender.send(email);
//					
//				        model.put("EmailId",recipientAddress);
//				    return new ModelAndView("/OTP",model);
//				    }
//				    else
//				    {
//				    	 model.addAttribute("Status", "Please check your credentials");
//			    		 return new ModelAndView("/ForgotPassword",model);
//				    }
//				   
//	    }
//				  
//	        // forwards to the view named "Result"
//			catch(Exception e){
//				System.out.println("Exception: "+ e);
//				return new ModelAndView("/error");
//	
//			
//			}    
//	    		
//	    }
//	    	else
//	    	{
//	    		model.addAttribute("Status", "Please check your credentials");
//	    		 return new ModelAndView("/ForgotPassword",model);
//	    	}
//			
//	}
//	    
//	    @RequestMapping(value="OTP", method = RequestMethod.POST)
//	    public  ModelAndView verifyotp(@RequestParam("otp") String otp ,@RequestParam("email") String email, ModelMap model) 
//	    {
//	    	 UserDTO retrievedDTO = userService.getUserDTOByEmailId(email);
//	    	 //System.out.println("the value is "+retrievedDTO.getOtp());
//	    	 //System.out.println("the value is "+otp);
//	    	 //int onetime=Integer.parseInt(otp);
//	    	 //int retrievedonetime=Integer.parseInt(retrievedDTO.getOtp());
//	    	 //System.out.println("onetime"+onetime+"reterieved one time"+retrievedonetime);
//	    	 
//	    	 if(otp.equals(retrievedDTO.getOtp()))
//	    	 {
//	    		 model.put("EmailId",email);
//	    		 return new ModelAndView("/resetpassword",model);
//	    	 }
//	    	 else
//	    	 {
//	    		
//	    		 model.addAttribute("Status", "Please Try Again");
//	    		 model.addAttribute("EmailId", email);
//	    		 return new ModelAndView("/OTP",model);
//	    	 }
//	    	 
//	    }
//	    
//	    @RequestMapping(value="resetpassword", method = RequestMethod.POST)
//	    public  ModelAndView confirmpassword(@RequestParam("password") String password ,@RequestParam("email") String email, ModelMap model) 
//	    {
//	    	try
//    		{
//	    	 UserDTO retrievedDTO = userService.getUserDTOByEmailId(email);
//	    	 //System.out.println("the value is "+retrievedDTO.getOtp());
//	    	 //System.out.println("the value is "+otp);
//	    	
//	    	 retrievedDTO.setPassword(password);
//	    	 Boolean updatepassword = userService.updatepassword(retrievedDTO);
//	    	 model.addAttribute("Status","Password updated. Please login with new password");
//				return new ModelAndView("/securedLogin/login",model);
//    		}
//	    	
//	    	catch(Exception e){
//	    					System.out.println("Exception: "+ e);
//	    					return new ModelAndView("/error");
//	    }
//	  }
//	    
//}
//
//
