package edu.irabank.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.irabank.dao.UserDAO;
import edu.irabank.dto.UsersDTO;

@Repository
public class UserDAOImpl implements UserDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public String retrievePassword(String userName)	
	{
		Session session = sessionFactory.getCurrentSession();
		String queryString = "FROM UsersDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		String password = ((UsersDTO) query.uniqueResult()).getPassword();
		return password;
	}
	
	public UsersDTO getUserDTO(String userName)
	{
		Session session = sessionFactory.getCurrentSession();
		String queryString = "FROM UsersDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		UsersDTO userDTO = (UsersDTO) query.uniqueResult();
		//System.out.println("Password = " + password);
		return userDTO;
	}

	public Integer retrieveUserID(String userName)	
	{
		Session session = sessionFactory.openSession();
		String queryString = "FROM UsersDTO u WHERE u.userName = :userName";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName);
		Integer user_id = ((UsersDTO) query.uniqueResult()).getUserId();
		//System.out.println("Password = " + password);
		return user_id;
	}
}



