package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.UserIssueDAO;
import edu.irabank.dto.RequestDetailsDTO;

/**
 * @author Ramki Subramanian
 *
 */

@Repository
public class UserIssueDAOImpl implements UserIssueDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param userName
	 * @return Integer
	 */
	
	@Override
	public Boolean addNewIssue(RequestDetailsDTO requestdetailsdto) {
		System.out.println("try in DAOImpl");
		// TODO check if the user is already present in service Layer
		try{
			sessionFactory.getCurrentSession().save(requestdetailsdto);
			return true;
		}
		catch (ConstraintViolationException e){
		 System.out.println("The error is "+ e);
		 //e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewIssue
}



