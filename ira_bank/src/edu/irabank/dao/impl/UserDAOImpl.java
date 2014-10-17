package edu.irabank.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.UserDAO;
import edu.irabank.dto.UserDTO;

/**
 * @author Ramki Subramanian
 *
 */

@Repository
public class UserDAOImpl implements UserDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDTO getUserDTOByUsername(String userName)
	{
		Session session = sessionFactory.getCurrentSession();
		String queryString = "FROM UsersDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		UserDTO userDTO = (UserDTO) query.uniqueResult();
		//System.out.println("Password = " + password);
		return userDTO;
	}
	
	// Used in Login
	public String getPassword(String userName)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UsersDTO.findByUserName"); //using NamedQuery
		//System.out.println("query" + query);
		query.setParameter("userName", userName);
		String password = ((UserDTO) query.uniqueResult()).getPassword();
		return password;
	}


	/**
	 * @param userName
	 * @return Integer
	 */
	public Integer retrieveUserID(String userName)	
	{
		Session session = sessionFactory.openSession();
		String queryString = "FROM UsersDTO u WHERE u.userName = :userName";
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
		catch (Exception e){
		 System.out.println("The error is "+e);
		 e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewuser
	 
	
}



