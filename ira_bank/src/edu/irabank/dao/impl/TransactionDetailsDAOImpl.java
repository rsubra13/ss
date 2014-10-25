package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dto.TransactionDetailsDTO;

/**
 * @author Abha Upadhyay
 *
 */

@Repository
public class TransactionDetailsDAOImpl implements TransactionDetailsDAO 	
{
	/*
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDTO getUserDTOByUsername(String userName)
	{
		System.out.println("28 : getUserDTOByUsername " + userName);
		Session session = sessionFactory.getCurrentSession();
		String queryString = "FROM UserDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		
		UserDTO userDTO = (UserDTO) query.uniqueResult();
		try{
		System.out.println("query : " + query);
		System.out.println("Retrieved UserName = " + userDTO);
		}
		
		
		catch(Exception e){
		System.out.println("41 : the exception is " + e);
		e.printStackTrace();
			
		}
		
		return userDTO;
		
	}
	
	// Used in Login
	public String getPassword(String userName)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UserDTO.findByUserName"); //using NamedQuery
		System.out.println("userName here: " + userName);
		query.setParameter("userName", userName);
		System.out.println("query : " + query);
		String password = ((UserDTO) query.uniqueResult()).getPassword();
		return password;
	}


	/**
	 * @param userName
	 * @return Integer
	 */
	/*
	public Integer retrieveUserID(String userName)	
	{
		Session session = sessionFactory.openSession();
		String queryString = "FROM UserDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		Integer user_id = ((UserDTO) query.uniqueResult()).getUserId();
		return user_id;
	}

	// Save the User to the DB and return success or failure to service.
	@Override
	public Boolean addNewUser(UserDTO userDTO) {
		
		// TODO check if the user is already present in service Layer
		try{
			sessionFactory.getCurrentSession().save(userDTO);
			return true;
		}
		catch (ConstraintViolationException e){
		 System.out.println("The error is "+ e);
		 e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewuser

	@Override
	public UserDTO getUserDTOByUserID(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> listUsers() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(UserDTO.class).list();
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return null; 
		// TODO Auto-generated method stub
		
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
   */
	
}



