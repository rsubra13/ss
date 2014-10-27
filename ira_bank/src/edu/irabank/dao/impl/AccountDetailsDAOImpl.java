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
	
	public boolean getAccountNum(String accountNO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accountNO);
		query.setParameter("accountNumber", accountNO);
		System.out.println("query : " + query);
		
		try{
			String accountno = ((AccountDetailsDTO) query.uniqueResult()).getAccountNumber();
			System.out.println("query : " + query);
			System.out.println("Retrieved Accountnumber = " + accountno);
			return true;
			}			
			catch(Exception e){
			System.out.println("41 : the exception is " + e);
			e.printStackTrace();
			return false;
				
			}
		
	}
	
	public int getBalance(String accntno)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accntno);
		query.setParameter("accountNumber", accntno);
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
		query.setParameter("accountNumber", accountno);
		System.out.println("query : " + query);
		((AccountDetailsDTO) query.uniqueResult()).setBalance(balance);
		return true;
	}

   
	
}




