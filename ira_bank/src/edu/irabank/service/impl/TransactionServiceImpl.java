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
					try{
						sessionFactory.getCurrentSession().save(newTransaction);
						return true;
					}
					catch (ConstraintViolationException e){
					 System.out.println("The error is "+ e);
					 return false;	 
					}
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
					try{
						sessionFactory.getCurrentSession().save(newTransaction);
						return true;
					}
					catch (ConstraintViolationException e){
					 System.out.println("The error is "+ e);
					 //e.printStackTrace();
					 return false;	 
					}
				}
			}
		return false;
	}

}

