package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.form.AccountFormBean;
import edu.irabank.service.TransactionService;


	@Controller
	public class TransactionController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Credit/Debit Form
		@RequestMapping(value="/ExternalUsers/credit_debit", method = RequestMethod.GET)
		public String createNewCreditDebit(ModelMap model) {
			// redirect to the CreditDebit.jsp
			System.out.println("comes at credit_debit get method");
			return "/ExternalUsers/credit_debit";
		}
		
		// Post Method after submitting Account details in CreditDebit Form
		@RequestMapping(value="/credit_debit", method=RequestMethod.POST)
	    public ModelAndView accountCreditDebit(@ModelAttribute("accountFormBean") AccountFormBean accountFormBean,  BindingResult result, ModelMap model, SessionStatus status)
	    {
			System.out.println("comes at credit_debit post method");
			/*
			boolean isAccntDetailSucccess = validateAccntFields(accountNo, balAnce);
			System.out.println("isAccntDetail" + isAccntDetailSucccess);
			if(isAccntDetailSucccess == true)
			{
				if(type == "Credit")
				{
					//Call CreditBalance to add the amount to the given account number
					boolean isCreditSuccess = transactionService.CreditBalance(accountNo, balAnce);
					System.out.println("isCreditSuccess" + isCreditSuccess);
					if(isCreditSuccess == true)
					{
						// To check what to put here
						return new ModelAndView("/ExternalUsers/credit_debit").addObject("accountSuccess", "Account Credited Successfully!");
					
					}
				}
				else if(type == "Debit")
				{
					//Call DebitBalance to add the amount to the given account number
					boolean isDebitSuccess = transactionService.DebitBalance(accountNo, balAnce);
					System.out.println("isDebitSuccess" + isDebitSuccess);
					if(isDebitSuccess == true)
					{
						// To check what to put here
						return new ModelAndView("/ExternalUsers/credit_debit").addObject("accountSuccess", "Account Debited Successfully!");
					
					}
				}
			}
			return new ModelAndView("/ExternalUsers/credit_debit").addObject("accountError", "Invalid AccountID or balance not sufficient!");
		}
		
		
		
		public boolean validateAccntFields(String accountNo, Integer balance)
		{
			// To Do: how to check the value of Integer type as empty
			if(accountNo.isEmpty())
			{
				return false;
			}
			return true;
		}
		*/
			String Accountnum = transactionService.getAccountDTOByAccountNumber(accountFormBean.getAccountNumber());
			boolean isAccountExist = false;
			if(Accountnum.isEmpty())
			{
				isAccountExist = false;
			}
			else if(Accountnum != null)
			{
				isAccountExist = true;
			}
			if(isAccountExist)
			{
				Integer balAnce = accountFormBean.getbalance();
				String type = accountFormBean.getCreditDebit();
				if(type == "Credit")
				{
					//Call CreditBalance to add the amount to the given account number
					boolean isCreditSuccess = transactionService.CreditBalance(Accountnum, balAnce);
					System.out.println("isCreditSuccess" + isCreditSuccess);
					if(isCreditSuccess == true)
					{
						System.out.println("Account Credited Successfully! ");
						model.addAttribute("accountStatus", "Account Credited Successfully!");
						model.addAttribute("accountFormBean",accountFormBean);
						return new ModelAndView("/ExternalUsers/credit_debit", model);
					
					}
				}
				else if(type == "Debit")
				{
					//	Call DebitBalance to add the amount to the given account number
					boolean isDebitSuccess = transactionService.DebitBalance(Accountnum, balAnce);
					System.out.println("isDebitSuccess" + isDebitSuccess);
					if(isDebitSuccess == true)
					{
						System.out.println("Account Debited Successfully!");
						model.addAttribute("accountStatus", "Account Debited Successfully!");
						model.addAttribute("accountFormBean",accountFormBean);
						return new ModelAndView("/ExternalUsers/credit_debit", model);
					}
				}
			}
			else 
			{
				System.out.println("Account doesn't exists ");
				model.addAttribute("accountStatus", "Please enter a valid account number");
				model.addAttribute("accountFormBean",accountFormBean);
				return new ModelAndView("/ExternalUsers/credit_debit", model);
			}
			model.addAttribute("accountStatus", "Please enter a valid account number");
			model.addAttribute("accountFormBean",accountFormBean);
		return new ModelAndView("/ExternalUsers/credit_debit", model);
	   }
	}
	 
	
