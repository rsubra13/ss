package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.AccountDetailsDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Abha Upadhyay
 *
 */


@Repository
public class AccountDetailsDAOImpl implements AccountDetailsDAO 	
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public String getAccountDTOByAccountNumber(String accountNO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accountNO);
		query.setParameter("accountNO", accountNO);
		System.out.println("query : " + query);
		String accountno = ((AccountDetailsDTO) query.uniqueResult()).getAccountNumber();
		return accountno;
		
	}
	
		
	// Used in Credit/Debit
	public String getAccountNumber(String accountno)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accountno);
		query.setParameter("accountNO", accountno);
		System.out.println("query : " + query);
		String accountNo = ((AccountDetailsDTO) query.uniqueResult()).getAccountNumber();
		return accountNo;
	}
	// Used in Credit/Debit
	public int getBalance(String accntno)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accntno);
		query.setParameter("accountNO", accntno);
		System.out.println("query : " + query);
		Integer Balance = ((AccountDetailsDTO) query.uniqueResult()).getBalance();
		return Balance;
	}
	//Used in Credit and Debit to Update Balance

	public boolean updateBalance(String accountno, Integer balance)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("Balance here: " + balance);
		query.setParameter("accountNO", accountno);
		System.out.println("query : " + query);
		((AccountDetailsDTO) query.uniqueResult()).setBalance(balance);
		//To Do
		return true;
	}

   
	
}




