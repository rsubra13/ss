package edu.irabank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import edu.irabank.dto.BillPayDTO;
import edu.irabank.form.BillpaymerchantFormBean;
import edu.irabank.form.BillpaymerchantapproveFormBean;
import edu.irabank.form.BillpayrequestFormBean;
import edu.irabank.form.BillpayuserFormBean;
import edu.irabank.service.TransactionService;



	@Controller
	@SessionAttributes
	
	public class BillpayMerchantController 
	{
		
		@Autowired
		private TransactionService transactionService; 
		
		@Autowired
		HttpSession sessionID;

		
		// GET Method of Billpay Merchant Form
		@RequestMapping(value="/ExternalUsers/Billpaymerchant", method = RequestMethod.GET)
		public String createNewTransfer(ModelMap model) {
			System.out.println("comes at Billpay Merchant get method");
			return "/ExternalUsers/Billpaymerchant";
		}
		
		// Post Method after submitting Account detail and amount in Billpay Merchant Form
		@RequestMapping(value="/ExternalUsers/Billpaymerchant", method=RequestMethod.POST)
	    public ModelAndView accountTransfer(@ModelAttribute("billpaymerchantFormBean")@Valid BillpaymerchantFormBean billpaymerchantFormBean,  BindingResult result, ModelMap model)
	    {
			// Arraylist option for displaying errors.
			
			ArrayList<String> errorCode = new ArrayList<String>();
			
			// Case 1: JSR303 validation. Checks for Hibernate related form issues.
			
			if (result.hasErrors()){
				System.out.println("comes in form errors of merchant billpay");
				model.addAttribute("accountStatus", "Please fill the necessary fields and try again");
				model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
				return new ModelAndView( "/ExternalUsers/Billpaymerchant",model);
			}
			
			// Case 2 : Server-side validation : Start the validation before pressing the submit button.
	
			Boolean serverValidationError = false;
			
			// Check for all the billpaymerchantFormBean values.
			if(billpaymerchantFormBean.getAccount()==null || !billpaymerchantFormBean.getAccount().matches("^[0-9 -]+$"))
			{
				errorCode.add("Please check the Account Number. It is not in expected format.");
				model.addAttribute("accountStatus",errorCode);
				serverValidationError = true;
			}
			
			if(Double.valueOf(billpaymerchantFormBean.getAmount())==null || !Double.valueOf(billpaymerchantFormBean.getAmount()).toString().matches("[0-9]{1,13}(\\.[0-9]*)?"))
			{
				errorCode.add("Please check the Amount. It is not in expected format.");
				model.addAttribute("accountStatus",errorCode);
				serverValidationError = true;
			}
			
			// Go back to register page with these validation errors.
			if(serverValidationError){
				return new ModelAndView("/ExternalUsers/Billpaymerchant", model); // return back to register
			}
			
			if(!serverValidationError)
			{
			System.out.println("comes at Billpay Merchant post method");
			String status = "MerchantPending";
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
			}
			model.addAttribute("accountStatus", "Please enter valid details");
			model.addAttribute("billpaymerchantFormBean",billpaymerchantFormBean);
			return new ModelAndView("/ExternalUsers/Billpaymerchant", model);

		}

		
		// Get Method for Bill Pay employee request page	
		@RequestMapping(value="/InternalUsers/BillpayRequests", method = RequestMethod.GET)
		public String Billpayrequests(ModelMap model) {
			
			model.put("BillPayDTO", new BillPayDTO());
			model.put("BillpayInfo",transactionService.showBillpayInfo());
			System.out.println(transactionService.showBillpayInfo());
	
			return "/InternalUsers/BillpayRequests";
		}
		
		// Post Method after clicking the Accept or Reject Button in Billpay employee Request Form
		@RequestMapping(value="/InternalUsers/BillpayRequests", method=RequestMethod.POST)
	    public ModelAndView accountTransfer(@ModelAttribute("billpayrequestFormBean") @Valid BillpayrequestFormBean billpayrequestFormBean,  BindingResult result, ModelMap model)
	    {
			
			System.out.println("comes at Billpay Request post method");
			String FromAccount = billpayrequestFormBean.getAccountno();
			Double amount = billpayrequestFormBean.getAmount();
			String action = billpayrequestFormBean.getAction();
			Integer merchantId = billpayrequestFormBean.getMerchantid();
			Integer billid = billpayrequestFormBean.getBillid();
			String ToAccount = transactionService.getAccountNumberbyUserID(merchantId);
			System.out.println("Merchant Account Number" + merchantId );
			
			if(action.equals("Accept"))
			{
				    						
					//Call BillPayupdate to update the status 

						boolean isTransferSuccess = transactionService.TransferBalance(ToAccount, FromAccount, amount);
						System.out.println("isTransferSuccess" + isTransferSuccess);
						if(isTransferSuccess)
						{
							String status = "BankApproved";	
							boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
							System.out.println("isBillpaySuccess" + isBillpaySuccess);
							if(isBillpaySuccess)
							{
								System.out.println("Bill pay Approved!");
								model.addAttribute("accountStatus", "Bill pay Approved!");
								model.addAttribute("billpayrequestFormBean",billpayrequestFormBean);
								model.put("BillPayDTO", new BillPayDTO());
								model.put("BillpayInfo",transactionService.showBillpayInfo());
								return new ModelAndView("/InternalUsers/BillpayRequests", model);
							}
						}
						else
						{
							String status = "BankRejected";	
							boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
							System.out.println("isBillpaySuccess" + isBillpaySuccess);
							System.out.println("Insufficient Balance!");
							model.addAttribute("accountStatus", "Insufficient Balance!");
							model.addAttribute("billpayrequestFormBean",billpayrequestFormBean);
							model.put("BillPayDTO", new BillPayDTO());
							model.put("BillpayInfo",transactionService.showBillpayInfo());
							return new ModelAndView("/InternalUsers/BillpayRequests", model);
							
						}
					}
			if(action.equals("Reject"))
			{
				    String status = "BankRejected";			
					//Call BillPayupdate to update the status 
					boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay Rejected!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpayrequestFormBean",billpayrequestFormBean);
						model.put("BillPayDTO", new BillPayDTO());
						model.put("BillpayInfo",transactionService.showBillpayInfo());
						return new ModelAndView("/InternalUsers/BillpayRequests", model);
					
					}
			}

			model.addAttribute("accountStatus", action);
			model.addAttribute("billpayrequestFormBean",action);
			return new ModelAndView("/InternalUsers/BillpayRequests", model);
		}
		
		
		
		
		// Get Method for Bill Pay user request page	
		@RequestMapping(value="/ExternalUsers/BillpayUser", method = RequestMethod.GET)
		public String Billpayuserrequests(ModelMap model) {
			
			model.put("BillPayDTO", new BillPayDTO());
			model.put("BillpayInfo",transactionService.showBillpayInfo());
			System.out.println(transactionService.showBillpayInfo());
			Integer userId = (Integer)sessionID.getAttribute("userId");
			String Accountno = transactionService.getAccountNumberbyUserID(userId);
			System.out.println("User Account Number" + Accountno );
			model.put("Useracount", Accountno);
	
			return "/ExternalUsers/BillpayUser";
		}
		
		// Post Method after clicking the Accept or Reject Button in Billpay user Request Form
		@RequestMapping(value="/ExternalUsers/BillpayUser", method=RequestMethod.POST)
	    public ModelAndView Billpayuserrequest(@ModelAttribute("billpayuserFormBean")@Valid BillpayuserFormBean billpayuserFormBean,  BindingResult result, ModelMap model)
	    {
			
			System.out.println("comes at Billpay Request post method");
			Integer billid = billpayuserFormBean.getBillid();
			String Account = billpayuserFormBean.getAccountno();
			Double amount = billpayuserFormBean.getAmount();
			String action = billpayuserFormBean.getAction();
			Integer userId = (Integer)sessionID.getAttribute("userId");
			String Accountno = transactionService.getAccountNumberbyUserID(userId);
			System.out.println(billid);
			System.out.println(action);
			
			if(action.equals("Accept"))
			{
				    String status = "UserApproved";							
					//Call BillPayupdate to update the status 
					boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay Accepted!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpayuserFormBean",billpayuserFormBean);
						model.put("BillPayDTO", new BillPayDTO());
						model.put("BillpayInfo",transactionService.showBillpayInfo());
						model.put("Useracount", Accountno);
						return new ModelAndView("/ExternalUsers/BillpayUser", model);
					
					}
			}
			if(action.equals("Reject"))
			{
				    String status = "UserRejected";			
					//Call BillPayupdate to update the status 
					boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay Rejected!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpayuserFormBean",billpayuserFormBean);
						model.put("BillPayDTO", new BillPayDTO());
						model.put("BillpayInfo",transactionService.showBillpayInfo());
						model.put("Useracount", Accountno);
						return new ModelAndView("/ExternalUsers/BillpayUser", model);
					
					}
			}

			model.addAttribute("accountStatus", action);
			model.addAttribute("billpayuserFormBean",action);
			return new ModelAndView("/ExternalUsers/BillpayUser", model);
		}
		
		
		
		// Get Method for Bill Pay Merchant Approve request page	
		@RequestMapping(value="/ExternalUsers/BillpaymerchantApprove", method = RequestMethod.GET)
		public String Billpaymerchantapprove(ModelMap model) {
			List<BillPayDTO> list1 = transactionService.showBillpayInfo();
			
			System.out.println("list1:" + list1);
			model.put("BillPayDTO", new BillPayDTO());
			model.put("BillpayInfo",transactionService.showBillpayInfo());
			System.out.println(transactionService.showBillpayInfo());
			Integer userId = (Integer)sessionID.getAttribute("userId");
			model.put("UserID", userId);
	
			return "/ExternalUsers/BillpaymerchantApprove";
		}
		
		// Post Method after clicking the Accept or Reject Button in Billpay user Request Form
		@RequestMapping(value="/ExternalUsers/BillpaymerchantApprove", method=RequestMethod.POST)
	    public ModelAndView Billpaymerchant(@ModelAttribute("billpaymerchantapproveFormBean")@Valid BillpaymerchantapproveFormBean billpaymerchantapproveFormBean,  BindingResult result, ModelMap model)
	    {
			
			System.out.println("comes at Billpay Request post method");
			Integer billid = billpaymerchantapproveFormBean.getBillid();
			String Account = billpaymerchantapproveFormBean.getAccountno();
			Double amount = billpaymerchantapproveFormBean.getAmount();
			String action = billpaymerchantapproveFormBean.getAction();
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println(billid);
			System.out.println(action);
			
			if(action.equals("Accept"))
			{
				    String status = "MerchantApproved";							
					//Call BillPayupdate to update the status 
					boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay Accepted!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpaymerchantapproveFormBean",billpaymerchantapproveFormBean);
						model.put("BillPayDTO", new BillPayDTO());
						model.put("BillpayInfo",transactionService.showBillpayInfo());
						System.out.println(transactionService.showBillpayInfo());
						model.put("UserID", userId);
						return new ModelAndView("/ExternalUsers/BillpaymerchantApprove", model);
					
					}
			}
			if(action.equals("Reject"))
			{
				    String status = "MerchantRejected";			
					//Call BillPayupdate to update the status 
					boolean isBillpaySuccess = transactionService.BillPayUpdate(billid, status);
					System.out.println("isBillpaySuccess" + isBillpaySuccess);
					if(isBillpaySuccess)
					{
						System.out.println("Bill pay Rejected!");
						model.addAttribute("accountStatus", "Bill pay request sent!");
						model.addAttribute("billpaymerchantapproveFormBean",billpaymerchantapproveFormBean);
						model.put("BillPayDTO", new BillPayDTO());
						model.put("BillpayInfo",transactionService.showBillpayInfo());
						System.out.println(transactionService.showBillpayInfo());
						model.put("UserID", userId);
						return new ModelAndView("/ExternalUsers/BillpaymerchantApprove", model);
					
					}
			}

			model.addAttribute("accountStatus", action);
			model.addAttribute("billpaymerchantapproveFormBean",action);
			return new ModelAndView("/ExternalUsers/BillpaymerchantApprove", model);
		}
		
	}
	 
	
