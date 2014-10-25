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

/**
 * @author Abha Upadhyay
 *
 */
/*

@Repository
public class AccountDetailsDAOImpl implements AccountDetailsDAO 	
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
		
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
	public int getBalance(int balance)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByBalance"); //using NamedQuery
		System.out.println("Balance here: " + balance);
		query.setParameter("Balance", balance);
		System.out.println("query : " + query);
		int Balance = ((AccountDetailsDTO) query.uniqueResult()).getBalance();
		return Balance;
	}
	//Used in Credit to Update Balance
	/*
	public Integer creditBalance(String accountno, int balance)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByBalance"); //using NamedQuery
		System.out.println("Balance here: " + balance);
		query.setParameter("Balance", balance);
		System.out.println("query : " + query);
		//int Balance = ((AccountDetailsDTO) query.uniqueResult()).getBalance();
		//return Balance;
	}*/

   
	
//}




