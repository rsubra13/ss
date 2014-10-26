package edu.irabank.dao.impl;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.SampTransDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
/**
 * @author Rakesh Subramanian
 *
 */
@Repository
public class SampTransDAOImpl implements SampTransDAO {
	
	public AccountDetailsDTO DTO = new AccountDetailsDTO();
	
	@Autowired
	private SessionFactory sessionFactory;
	/*public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}*/
	/*public SampTransDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	/*public SampTransDAOImpl(){}*/
	
	public AccountDetailsDTO getAccountsDTObyUserID(int userId)
	{
		try{
			HttpSession sessionID = null;
			sessionID.setAttribute("userId", userId);
		System.out.println("Entered Try Loop for DAO" + userId);
		//setSessionFactory(sessionFactory);	
		Session session = sessionFactory.getCurrentSession();	
		System.out.println("passed sessionfactory!!!!!!!!!!!!!");
		Query query = session.getNamedQuery("AccountDetailsDTO.findByUId");
		System.out.println("userName here: " + userId);
		query.setParameter("uId", userId);
		DTO = (AccountDetailsDTO) query.uniqueResult();
		System.out.println("Account Number: "+DTO.getAccountNumber());
		
		}
		catch(Exception e){
			System.out.println("Exception: "+ e);
		
		}
		return DTO;
		
	}
	
	private Session getSession() {
		Session sessionobj = getSessionFactory().getCurrentSession();
		if (sessionobj == null) {
			sessionobj = getSessionFactory().openSession();
		}
		return sessionobj;
	}
	private SessionFactory getSessionFactory() {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
/*if(sessionFactory == null)
{
	sesssionFactory = }*/
		return sessionFactory;
	}
	
	

}
