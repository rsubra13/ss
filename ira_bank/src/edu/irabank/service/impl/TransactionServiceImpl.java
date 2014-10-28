package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
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
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean getAccountNumber(String accountNO)
	{
		return accountdetailsDAO.getAccountNum(accountNO);
	}
	
	@Override
	@Transactional
	public boolean CreditBalance(String inputAccountNo, Integer inputbalance)
	{
		Integer userBalance = accountdetailsDAO.getBalance(inputAccountNo);
		Integer newBalance = userBalance + inputbalance;
				
			// Set balance to Account table
			boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(inputAccountNo, newBalance);
			System.out.println("isaccountUpdatesuccess" + isaccountUpdatesuccess);
			if(isaccountUpdatesuccess)
			{
				// Add row to transaction table
				Date sysDate = new Date();
				TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
				newTransaction.setTransDate(sysDate);
				newTransaction.setTransAmt(inputbalance);
				newTransaction.setToAcct(inputAccountNo);
							
				// Add this newly created TransactionDetailsDTO Object into the DB. 
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}					
		return false;
	}
	
	@Transactional
	public boolean DebitBalance(String inputAccNo, Integer inputbal)
	{
		
		Integer userBalance = accountdetailsDAO.getBalance(inputAccNo);
		if(userBalance >= inputbal)
		{
			Integer newBalance = userBalance - inputbal;
		
		
				// Set balance to Account table
				boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(inputAccNo, newBalance);
				System.out.println("isaccountUpdatesuccess" + isaccountUpdatesuccess);
				if(isaccountUpdatesuccess)
				{
					// Add row to transaction table
					Date sysDate = new Date();
					TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
					newTransaction.setTransDate(sysDate);
					newTransaction.setTransAmt(inputbal);
					newTransaction.setFromAcct(inputAccNo);
					// Add this newly created TransactionDetailsDTO Object into the DB.
					
					boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
					return transDetailsave;
				}
			}
		return false;
	}
	
	@Transactional
	public String getAccountNumberbyUserID(Integer UserID)
	{
		
		String accountnum = accountdetailsDAO.getAccountNumbyUserID(UserID);
		return accountnum;
		
	}
	
	@Transactional
	public boolean TransferBalance(String toAccount, String fromAccount, Integer inputbal)
	{
		Integer toBalance = accountdetailsDAO.getBalance(toAccount);
		Integer fromBalance = accountdetailsDAO.getBalance(fromAccount);
		if(fromBalance < inputbal)
		{
			return false;
	
		}
		else
		{
			Integer newtoBalance = toBalance + inputbal;
			Integer newfromBalance = fromBalance - inputbal;
			// Set balance to To Account table
			boolean istoaccountUpdatesuccess = accountdetailsDAO.updateBalance(toAccount, newtoBalance);
			boolean isfromaccountUpdatesuccess = accountdetailsDAO.updateBalance(fromAccount, newfromBalance);
			System.out.println("istoaccountUpdatesuccess" + istoaccountUpdatesuccess);
			System.out.println("isfromaccountUpdatesuccess" + isfromaccountUpdatesuccess);
			if(istoaccountUpdatesuccess && isfromaccountUpdatesuccess)
			{
				// Add row to transaction table
				Date sysDate = new Date();
				TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
				newTransaction.setTransDate(sysDate);
				newTransaction.setTransAmt(inputbal);
				newTransaction.setFromAcct(fromAccount);
				newTransaction.setToAcct(toAccount);
				// Add this newly created TransactionDetailsDTO Object into the DB.			
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}
			return false;
		}	
	}
}

