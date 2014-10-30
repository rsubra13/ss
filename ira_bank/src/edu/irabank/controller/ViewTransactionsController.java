package edu.irabank.controller;

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
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}


}
