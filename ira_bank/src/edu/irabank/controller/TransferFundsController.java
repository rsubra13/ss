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

import edu.irabank.form.TransferFormBean;
import edu.irabank.service.TransactionService;


	@Controller
	@SessionAttributes
	@RequestMapping("ExternalUsers")
	public class TransferFundsController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Transfer Funds
		@RequestMapping(value="/Transfer_funds", method = RequestMethod.GET)
		public String createNewTransfer(HttpSession sessionID, HttpServletRequest request) {
			String userName = (String)sessionID.getAttribute("userName");
			System.out.println("userName is:" + userName);
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println("userID is:" + userId);
			String Accountnum = transactionService.getAccountNumberbyUserID(userId);
			request.setAttribute("TextValue",Accountnum);
			
			// redirect to the Transfer_funds.jsp
			System.out.println("comes at Transfer get method");
			return "/ExternalUsers/Transfer_funds";
		}
		
		// Post Method after submitting Account details in Transfer Form
		@RequestMapping(value="/Transfer_funds", method=RequestMethod.POST)
	    public ModelAndView accountTransfer(@ModelAttribute("transferFormBean") TransferFormBean transferFormBean,  BindingResult result, ModelMap model, SessionStatus status, HttpSession sessionID, HttpServletRequest request)
	    {
			String userName = (String)sessionID.getAttribute("userName");
			System.out.println("userName is:" + userName);
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println("userID is:" + userId);
			String Accountnum = transactionService.getAccountNumberbyUserID(userId);
			request.setAttribute("TextValue",Accountnum);
			
			System.out.println("comes at Transfer post method");
			String FromAccount = transferFormBean.getFromaccount();
			String ToAccount = transferFormBean.getToaccount();
			Double amount = Double.parseDouble(transferFormBean.getAmount());
			
			boolean isFromAccountExist = transactionService.getAccountNumber(FromAccount);
			boolean isToAccountExist = transactionService.getAccountNumber(ToAccount);
			
			if(!isFromAccountExist || !isToAccountExist) 
			{
				System.out.println("Enter a valid account number ");
				model.addAttribute("transferStatus", "Please enter a valid account number");
				model.addAttribute("transferFormBean",transferFormBean);
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView("/ExternalUsers/Transfer_funds", model);
			}
			else if(FromAccount.equals(ToAccount))
			{
				System.out.println("Enter a valid account number ");
				model.addAttribute("transferStatus", "Please enter a valid account number");
				model.addAttribute("transferFormBean",transferFormBean);
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView("/ExternalUsers/Transfer_funds", model);
			}
			else if(amount <= 0)
			{
				System.out.println("Enter a valid Amount ");
				model.addAttribute("transferStatus", "Please enter a valid Amount");
				model.addAttribute("transferFormBean",transferFormBean);
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView("/ExternalUsers/Transfer_funds", model);
				
			}
			
			if(isFromAccountExist && isToAccountExist)
			{
				System.out.println("isToAccountExist" + isToAccountExist);
				System.out.println("isFromAccountExist" + isFromAccountExist);
								
					//Call TransferBalance to add the amount to the given account number
					boolean isTransferSuccess = transactionService.TransferBalance(ToAccount, FromAccount, amount);
					System.out.println("isTransferSuccess" + isTransferSuccess);
					if(isTransferSuccess)
					{
						System.out.println("Transfer Successfull!");
						model.addAttribute("transferStatus", "Transfer Successfull!");
						model.addAttribute("transferFormBean",transferFormBean);
						request.setAttribute("TextValue",Accountnum);
						return new ModelAndView("/ExternalUsers/Transfer_funds", model);
					
					}

			}
			model.addAttribute("transferStatus", "Please enter valid details");
			model.addAttribute("transferFormBean",transferFormBean);
			request.setAttribute("TextValue",Accountnum);
			return new ModelAndView("/ExternalUsers/Transfer_funds", model);
		}

	}
	 
	
