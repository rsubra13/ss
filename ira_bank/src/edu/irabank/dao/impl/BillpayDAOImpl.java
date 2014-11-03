package edu.irabank.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.BillpayDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.BillPayDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Abha Upadhyay
 *
 */

@Repository
public class BillpayDAOImpl implements BillpayDAO 

{
@Autowired 
private SessionFactory sessionFactory;
@Autowired
HttpSession sessionID;

	
	@Override
	public Boolean BillpaySave(BillPayDTO billpayDTO) {
	System.out.println("Entered Save Hibernate");
	try{
		System.out.println("Billpay DTO" + billpayDTO.getAcctNumber() + billpayDTO.getMerchantId());
		sessionFactory.getCurrentSession().merge(billpayDTO);
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BillPayDTO> showbillpayInfo() {
		System.out.println("Listing Bill Pay issues");
		Query query =  getSession().createQuery("SELECT b FROM BillPayDTO b");
		return query.list();
		//return getSession().createCriteria(BillPayDTO.class).list();
	}
	
	@Override
	public boolean Billpayupdatestatus(Integer billid, String Status)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("BillPayDTO.findByBillId"); //using NamedQuery
		query.setParameter("billId", billid);
		System.out.println("query : " + query);
		((BillPayDTO) query.uniqueResult()).setStatus(Status);
		return true;
	}
	
	
	@Override
	public boolean Billpayupdatekey(Integer billid, String hashedkey)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("BillPayDTO.findByBillId"); //using NamedQuery
		query.setParameter("billId", billid);
		System.out.println("query : " + query);
		((BillPayDTO) query.uniqueResult()).setHashedkey(hashedkey);
		return true;
	}
	
	//Used in BillpayMerchant controller
	public String gethashedKey(Integer billId)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("BillPayDTO.findBybillId"); //using NamedQuery
		//System.out.println("userName here: " + userName);
		query.setParameter("billId", billId);
		//System.out.println("query : " + query);
		String hashedKey = ((BillPayDTO) query.uniqueResult()).getHashedkey();
		return hashedKey;
		
		
	}
	
	
	
	
}





