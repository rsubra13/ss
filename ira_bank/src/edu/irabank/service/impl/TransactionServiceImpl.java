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
//import edu.irabank.dao.impl.AccountDetailsDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
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
	public String getAccountDTOByAccountNumber(String accountNO)
	{
		return accountdetailsDAO.getAccountDTOByAccountNumber(accountNO);
	}
	
	@Transactional
	public boolean CreditBalance(String inputAccountNo, Integer inputbalance)
	{
		
		String userAccountNo = accountdetailsDAO.getAccountNumber(inputAccountNo);
		Integer userBalance = accountdetailsDAO.getBalance(inputAccountNo);
		Integer newBalance = userBalance + inputbalance;
		
		if(!userAccountNo.isEmpty())
		{
			
			// Set balance to Account table
			boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(userAccountNo, newBalance);
			if(isaccountUpdatesuccess)
			{
				// Add row to transaction table
				Date sysDate = new Date();
				TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
				// 	Check what values need to be set
				newTransaction.setTransDate(sysDate);
				newTransaction.setTransAmt(newBalance);
				newTransaction.setToAcct(userAccountNo);	
			
				return true;
			}					
		}
		return false;
	}
	
	@Transactional
	public boolean DebitBalance(String inputAccNo, Integer inputbal)
	{
		
		String userAccountNo = accountdetailsDAO.getAccountNumber(inputAccNo);
		Integer userBalance = accountdetailsDAO.getBalance(inputAccNo);
		if(userBalance >= inputbal)
		{
			Integer newBalance = userBalance - inputbal;
		
			if(!userAccountNo.isEmpty())
			{
			
				// Set balance to Account table
				boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(userAccountNo, newBalance);
				if(isaccountUpdatesuccess)
				{
					// Add row to transaction table
					Date sysDate = new Date();
					TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
					// Check what values need to be set
					newTransaction.setTransDate(sysDate);
					newTransaction.setTransAmt(newBalance);
					newTransaction.setToAcct(userAccountNo);
			
					return true;
				}
			}
		}
		return false;
	}

}

