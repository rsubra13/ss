package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dao.impl.TransactionDetailsDAOImpl;
import edu.irabank.dto.TransactionDetailsDTO;

import edu.irabank.dao.AccountDetailsDAO;
import edu.irabank.dao.impl.AccountDetailsDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
//import edu.irabank.form.UserRegistrationFormBean;
import edu.irabank.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService
{
	
	@Autowired
	private TransactionDetailsDAO transactiondetailsDAO;
	
	@Autowired
	private AccountDetailsDAO accountdetailsDAO;
	
	
	@Transactional
	public boolean CreditBalance(String inputAccountNo, int inputbalance)
	{
		
		String userAccountNo = accountdetailsDAO.getAccountNumber(inputAccountNo);
		int userBalance = accountdetailsDAO.getBalance(inputbalance);
		int newBalance = userBalance + inputbalance;
		
		if(!userAccountNo.isEmpty() && !userBalance.isEmpty())
		{
			
			// Set balance to Account table
			boolean isaccountUpdatesuccess = accountdetailsDAO.updateAccount(userAccountNo);
			if(isaccountUpdatesuccess)
			{
			// Add row to transaction table
			TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
			// Check what values need to be set
			newTransaction.setTransID();
			newTransaction.setTransDate();
			newTransaction.setTransAmt(newBalance);
			newTransaction.setToAccnt(userAccountNo);			
			return true;
			}
			
			
		}
		return false;
	}



}
