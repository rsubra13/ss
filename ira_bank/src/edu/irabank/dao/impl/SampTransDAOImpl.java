package edu.irabank.dao.impl;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.SampTransDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
/**
 * @author Rakesh Subramanian
 *
 */
@Repository
public class SampTransDAOImpl implements SampTransDAO {
	
	 
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	HttpSession sessionID;
	@Autowired
	UserDAO userDAO;
	
	

	/*public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}*/
	/*public SampTransDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	/*public SampTransDAOImpl(){}*/
	@Override
	public AccountDetailsDTO getAccountsDTObyUserID(int userId)
	{
		try{
			/*HttpSession sessionID = null;
			sessionID.setAttribute("userId", userId);*/
		System.out.println("Entered Try Loop for DAO" + userId);
		
		
		
		
		System.out.println("passed sessionfactory!!!!!!!!!!!!!");
		
		//get UserDTO to pass it to AccountDetails
		UserDTO userDTO = new UserDTO();
		userDTO = userDAO.getUserDTOByUserId(userId);
		
		
		Query query = getSession().createQuery("SELECT a FROM AccountDetailsDTO a WHERE a.uId = :uId");
		System.out.println("userID here: " + userId);
		
		query.setParameter("uId", userDTO);
		AccountDetailsDTO DTO = (AccountDetailsDTO) query.uniqueResult();
		System.out.println("Account Number: "+DTO.getAccountNumber());
		System.out.println(DTO.getUId());
		return DTO;
		
		}
		catch(Exception e){
			System.out.println("Exception: "+ e);
			return null;
		
		}
		
		
	}
	@Override
		public Boolean RequestDetailsSave(RequestDetailsDTO requestDetailsDTO) {
		System.out.println("Entered Save Hibernate");
		try{
			sessionFactory.getCurrentSession().save(requestDetailsDTO);
			return true;
		}
		catch (Exception e){
		 System.out.println("The error is "+ e);
		 //e.printStackTrace();
		 return false;	 
		}
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
