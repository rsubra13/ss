package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.AccountDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;


/**
 * @author Ishaan Sharma
 *
 */

@Repository
public class AccountDAOImpl implements AccountDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
		// Save the Account to the DB and return success or failure to service.
	@Override
	public Boolean addNewAccount(AccountDetailsDTO accountdetailsDTO) {
		
		// TODO check if the account is already present in service Layer
		try{
			sessionFactory.getCurrentSession().save(accountdetailsDTO);
			return true;
		}
		catch (ConstraintViolationException e){
		 System.out.println("The error is "+ e);
		 e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewAccont
	
	@Override
	public AccountDetailsDTO getAccountDetailsDTOByUserID(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AccountDetailsDTO> listAccounts() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(AccountDetailsDTO.class).list();
	}
	
	@Override
	public Boolean deleteAccount(Integer accountID)
	{
		
		
		return null;
	}

		
	// To create/open a new session.
	private Session getSession() {
		Session sessionobj = getSessionFactory().getCurrentSession();
		if (sessionobj == null) {
			sessionobj = getSessionFactory().openSession();
		}
		return sessionobj;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   
	
}



