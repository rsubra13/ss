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

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.service.TransactionService;


	@Controller
	public class TransactionController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Credit/Debit Form
		@RequestMapping(value="ira_bank/pages/ExternalUsers/credit_debit", method = RequestMethod.GET)
		public String createNewCreditDebit(ModelMap model) {
			// redirect to the CreditDebit.jsp
			System.out.println("comes here");
			return "ira_bank/pages/ExternalUsers/credit_debit";
		}
		
		// Post Method after submitting Account details in CreditDebit Form
		@RequestMapping(value="ira_bank/pages/ExternalUsers/credit_debit", method=RequestMethod.POST)
	    public ModelAndView accountCreditDebit(@RequestParam("accountnumber") String accountNo, @RequestParam("balance") int balAnce,ModelMap model, SessionStatus status, HttpSession sessionID)
	    {
			boolean isAccntDetailSucccess = validateAccntFields(accountNo, balAnce);
			System.out.println("isAccntDetail" + isAccntDetailSucccess);
			if(isAccntDetailSucccess == true)
			{
				//Check credit and debit and add an if condition for credit and debit
				boolean isCreditSuccess = transactionService.CreditBalance(accountNo, balAnce);
				System.out.println("isCredDebSuccess" + isCreditSuccess);
				if(isCreditSuccess == true)
				{
					// To check where to return the control
					return new ModelAndView("/index").addObject("accountSuccess", "Account Credited/Debited Successfully!");
					
				}
			}
			//return new ModelAndView("/index").addObject("accountError", "Invalid AccountID or balance not sufficient!");
		}
		
		
		
		public boolean validateAccntFields(String accountNo, int balance)
		{
			
			if((accountNo.isEmpty()) || (balance.isNull()))
			{
				return false;
			}
			return true;
		}
}
	 
	 
	
