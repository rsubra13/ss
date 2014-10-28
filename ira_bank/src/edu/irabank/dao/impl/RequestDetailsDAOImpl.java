package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.irabank.dao.RequestDetailsDAO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Rakesh Subramanian
 *
 */

@Repository
public class RequestDetailsDAOImpl implements RequestDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequestDetailsDTO> listTransactions() {
		// TODO Auto-generated method stub
		System.out.println("listing users");
		return getSession().createCriteria(RequestDetailsDTO.class).list();
	}
	
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
