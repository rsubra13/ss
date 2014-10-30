package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dao.AccountDetailsDAO;
import edu.irabank.dao.BillpayDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.UserDTO;
import edu.irabank.dto.BillPayDTO;
import edu.irabank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{
	
	@Autowired
	private TransactionDetailsDAO transactiondetailsDAO;
	
	@Autowired
	private AccountDetailsDAO accountdetailsDAO;
	
	@Autowired
	private BillpayDAO billpayDAO;
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	@Autowired
	HttpSession sessionID;
		
	@Transactional
	public boolean getAccountNumber(String accountNO)
	{
		return accountdetailsDAO.getAccountNum(accountNO);
	}
	
	@Override
	@Transactional
	public boolean CreditBalance(String inputAccountNo, Double inputbalance)
	{
		Double userBalance = accountdetailsDAO.getBalance(inputAccountNo);
		Double newBalance = userBalance + inputbalance;
				
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
				newTransaction.setIsAuthorized(true);
							
				// Add this newly created TransactionDetailsDTO Object into the DB. 
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}					
		return false;
	}
	@Override
	@Transactional
	public boolean DebitBalance(String inputAccNo, Double inputbal)
	{
		
		Double userBalance = accountdetailsDAO.getBalance(inputAccNo);
		if(userBalance >= inputbal)
		{
			Double newBalance = userBalance - inputbal;
		
		
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
					newTransaction.setIsAuthorized(true);
					// Add this newly created TransactionDetailsDTO Object into the DB.
					
					boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
					return transDetailsave;
				}
			}
		return false;
	}
	
	@Override
	@Transactional
	public String getAccountNumberbyUserID(Integer UserID)
	{
		
		String accountnum = accountdetailsDAO.getAccountNumbyUserID(UserID);
		return accountnum;
		
	}
	@Override
	@Transactional
	public boolean TransferBalance(String toAccount, String fromAccount, Double inputbal)
	{
		Double toBalance = accountdetailsDAO.getBalance(toAccount);
		Double fromBalance = accountdetailsDAO.getBalance(fromAccount);
		if(fromBalance < inputbal)
		{
			return false;
	
		}
		else
		{
			Double newtoBalance = toBalance + inputbal;
			Double newfromBalance = fromBalance - inputbal;
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
				newTransaction.setIsAuthorized(true);
				// Add this newly created TransactionDetailsDTO Object into the DB.			
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}
			return false;
		}	
	}
	
	@Transactional
	public boolean BillPay(String AccountNo, Double balance, String status)
	{
		Integer userId = (Integer)sessionID.getAttribute("userId");
		System.out.println("userID is:" + userId);
		UserDTO merchantid = userDAOImpl.getUserDTOByUserId(userId);
		// Add row to BillPay table
		BillPayDTO newBillPay = new BillPayDTO();
		newBillPay.setAcctNumber(AccountNo);
		newBillPay.setAmount(balance);
		newBillPay.setStatus(status);
		newBillPay.setMerchantId(merchantid);
		
		// Add this newly created TransactionDetailsDTO Object into the DB.			
		boolean Billpaysave = billpayDAO.BillpaySave(newBillPay);
		return Billpaysave;
		
	}

	
	}




