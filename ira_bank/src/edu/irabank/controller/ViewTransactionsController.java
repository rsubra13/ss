package edu.irabank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.form.RequestDetailsPopulateBean;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.service.InternalTransactionService;
import edu.irabank.service.impl.InternalTransactionServiceImpl;

@Controller
public class ViewTransactionsController {
	@Autowired
	InternalTransactionService internalService;
	
	// List of un-approved transactions
	
	@RequestMapping(value="/admin/listTransactions", method = RequestMethod.GET)
	public String listAllTransactions(ModelMap model) {
		// redirect to the listTrans.jsp
		boolean val= true;
		model.addAttribute("button",true);
		model.addAttribute("useThis", val);
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}
	
	@RequestMapping(value="/admin/ApprovedTransactions", method = RequestMethod.GET)
	public String listAllApprovedTransactions(ModelMap model) {
		// redirect to the listTrans.jsp
		boolean approve= true;
		model.addAttribute("approved", approve);
		model.addAttribute("button",false);
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}
	@RequestMapping(value ="user/ExternalUsers/listTransactions", method = RequestMethod.GET)
	public String listALLUserTransactions(ModelMap model,HttpSession SessionId)
	{
		System.out.println("List User transaction, sessionId is "+ SessionId.getAttribute("userId"));
		boolean val= false;

		model.addAttribute("useThis", val);
		model.addAttribute("userIdCompare", SessionId.getAttribute("userId"));
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}


}
