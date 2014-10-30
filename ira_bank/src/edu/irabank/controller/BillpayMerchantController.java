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

import edu.irabank.form.BillpaymerchantFormBean;
import edu.irabank.service.TransactionService;


	@Controller
	@SessionAttributes
	@RequestMapping("ExternalUsers")
	public class BillpayMerchantController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Billpay Merchant Form
		@RequestMapping(value="/Billpaymerchant", method = RequestMethod.GET)
		public String createNewTransfer(ModelMap model) {
			System.out.println("comes at Billpay Merchant get method");
			return "/ExternalUsers/Billpaymerchant";
		}
		
		// Post Method after submitting Account detail and amount in Billpay Merchant Form
		@RequestMapping(value="/Billpaymerchant", method=RequestMethod.POST)
	    public ModelAndView accountTransfer(@ModelAttribute("billpaymerchantFormBean") BillpaymerchantFormBean billpaymerchantFormBean,  BindingResult result, ModelMap model)
	    {
			
			System.out.println("comes at Billpay Merchant post method");
			String status = "Pending";
			String Account = billpaymerchantFormBean.getAccount();
			Double amount = Double.parseDouble(billpaymerchantFormBean.getAmount());
			
			boolean isAccountExist = transactionService.getAccountNumber(Account);
			
			if(!isAccountExist) 
			{
				System.out.println("Please Enter a valid account number ");
				model.addAttribute("accountStatus", "Please enter a valid account number");
				model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
				return new ModelAndView("/ExternalUsers/Billpaymerchant", model);
			}
			else if(amount <= 0)
			{
				System.out.println("Please Enter a valid Amount ");
				model.addAttribute("accountStatus", "Please enter a valid Amount");
				model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
				return new ModelAndView("/ExternalUsers/Billpaymerchant", model);
				
			}
			
			if(isAccountExist)
			{
				System.out.println("isAccountExist" + isAccountExist);
								
					//Call BillPay to send a request 
					boolean isBillpaySuccess = transactionService.BillPay(Account, amount, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay request sent!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
						return new ModelAndView("/ExternalUsers/Billpaymerchant", model);
					
					}

			}
			model.addAttribute("accountStatus", "Please enter valid details");
			model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
			return new ModelAndView("/ExternalUsers/Billpaymerchant", model);
		}

	}
	 
	
