package edu.irabank.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.InternalTransactionFormBean;
import edu.irabank.service.InternalTransactionService;
import edu.irabank.service.TransactionService;
import edu.irabank.service.UserService;
import edu.irabank.service.impl.InternalTransactionServiceImpl;
/**
 * @author Rakesh Subramanian
 *
 */
@Controller
@SessionAttributes
public class InternalTransactionController 
{
	@Autowired
	private TransactionService transactionService; 
	@Autowired
	private InternalTransactionService internalTransactionService;

	// Ext Users request / create a new transaction.	
	@RequestMapping(value="/user/ExternalUsers/Request", method = RequestMethod.GET)
	public ModelAndView sampTransRoute( HttpSession sessionID,HttpServletRequest request,ModelMap model)
	{//userId
		
		String userName = (String)sessionID.getAttribute("userName");
		System.out.println("userName is:" + userName);
		int userId = (int)sessionID.getAttribute("userId");
		String Accountnum = transactionService.getAccountNumberbyUserID(userId);
		model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
		request.setAttribute("TextValue",Accountnum);
		System.out.println("userId is:" + userId);
		return new ModelAndView("/ExternalUsers/RequestTransaction");
		
	}
	
	// POST method of create Transaction -> 
	@RequestMapping(value="/user/CreateTransaction", method = RequestMethod.POST)
	public ModelAndView createTrans(@ModelAttribute("trans") InternalTransactionFormBean trans, HttpSession sessionID,ModelMap model)
	{
		String Accountnum = transactionService.getAccountNumberbyUserID((Integer)sessionID.getAttribute("userId"));
		System.out.println("Account number in controller is:"+Accountnum);
		
		String tranID = "";
		int userID = (int)sessionID.getAttribute("userId");
		
		
		System.out.println("userName is:" + userID);
		boolean isAuthorized0 = false;
		String[] empty = new String[1];
		empty[0] = "";
		String reqId = "";
		boolean isCreateSuccess = internalTransactionService.setTransactionDetails(trans, userID,isAuthorized0,tranID,empty,reqId);
		try{//System.out.println("Entered Try Loop for CreateTrans:"+isCreateSuccess);
		if(isCreateSuccess == true)
		{
			//internalTransactionService.setRequestDetails(trans, userId);
			model.addAttribute("userRegistrationStatus", "Transaction Done successfully");
			model.addAttribute("userName", sessionID.getAttribute("userName"));

		}
		
		}
		catch(Exception e){
			System.out.println("Exception: "+e);
	
		}
		return new ModelAndView("/ExternalUsers/RequestTransaction",model);
	}

	// Admin Transaction approval
	@RequestMapping(value = "admin/Transaction/Approval" ,method = RequestMethod.POST)
	public ModelAndView setIsAuthorized(@ModelAttribute("trans") InternalTransactionFormBean trans,@RequestParam("transId") String transId,@RequestParam("reqId") String reqId, @RequestParam("userId") int userId,@RequestParam("reqDesc")String reqDesc,HttpSession sessionID,HttpServletRequest request,ModelMap model)
	{//to_account and acmount need to be got!
		//after approve.. account details need to be changed and request and transact need to have isauthorized set.
		System.out.println("Entering Is_authorized");
		String Accountnum = transactionService.getAccountNumberbyUserID((Integer)sessionID.getAttribute("userId"));
		System.out.println("Account number in controller is:"+Accountnum);
		String userName = (String)sessionID.getAttribute("userName");
		/*String phrase = "the music made   it   hard      to        concentrate";
		String delims = "[ ]+";
		String[] tokens = phrase.split(delims);*/
		
		String delimeter = "[,]";
		String[] split = new String[2];
		 split = reqDesc.split(delimeter);
		System.out.println("From Splitting TO_ACCT: "+ split[1]);
		System.out.println("From Splitting Amount: "+ split[2]);

		System.out.println("userName is:" + userName);
		System.out.println("userName is:" + userId);
		
		boolean isAuthorized1 = true;
		boolean isCreateSuccess = internalTransactionService.setTransactionDetails(trans,userId,isAuthorized1,transId,split,reqId);
		try{
		if(isCreateSuccess == true)
		{
			//internalTransactionService.setRequestDetails(trans, userId);
			model.addAttribute("userRegistrationStatus", "Transaction Done successfully");
			model.addAttribute("userName", userName);

		}
		}
		catch(Exception e){System.out.println("Exception at APPROVAL"+e);}
		return new ModelAndView("/ExternalUsers/RequestTransaction",model);
		
	}
}
