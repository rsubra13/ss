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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.form.AccountFormBean;
import edu.irabank.service.TransactionService;


	@Controller
	@SessionAttributes
	@RequestMapping("ExternalUsers")
	public class TransactionController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Credit/Debit Form
		@RequestMapping(value="/credit_debit", method = RequestMethod.GET)
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
			String Accountnum = accountFormBean.getAccountNumber();
			System.out.println("balance from formbean account" + accountFormBean.getAccountNumber());
			System.out.println("balance from formbean" + accountFormBean.getAmount());
			Integer balAnce = Integer.parseInt(accountFormBean.getAmount());
			
			String type = accountFormBean.getCreditDebit();
			boolean isAccountExist = transactionService.getAccountNumber(Accountnum);
			
			if(!isAccountExist) 
			{
				System.out.println("Enter a valid account number ");
				model.addAttribute("accountStatus", "Please enter a valid account number");
				model.addAttribute("accountFormBean",accountFormBean);
				return new ModelAndView("/ExternalUsers/credit_debit", model);
			}
			else if(balAnce <= 0)
			{
				System.out.println("Enter a valid Amount ");
				model.addAttribute("accountStatus", "Please enter a valid Amount");
				model.addAttribute("accountFormBean",accountFormBean);
				return new ModelAndView("/ExternalUsers/credit_debit", model);
				
			}
			
			if(isAccountExist)
			{
				System.out.println("isAccountExist" + isAccountExist);
				System.out.println("type" + type);
				
				
				if(type.equals("Credit"))
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
				else if(type.equals("Debit"))
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
					else
					{
						System.out.println("Please Enter a valid amount!");
						model.addAttribute("accountStatus", "Please Enter a valid amount!");
						model.addAttribute("accountFormBean",accountFormBean);
						return new ModelAndView("/ExternalUsers/credit_debit", model);
						
					}
				}
			}
			model.addAttribute("accountStatus", "Please enter valid details");
			model.addAttribute("accountFormBean",accountFormBean);
		return new ModelAndView("/ExternalUsers/credit_debit", model);
		}

	}
	 
	
