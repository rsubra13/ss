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
import edu.irabank.dto.BillPayDTO;

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
		sessionFactory.getCurrentSession().save(billpayDTO);
		return true;
	}
	catch (Exception e){
	 System.out.println("The error is "+ e);
	 //e.printStackTrace();
	 return false;
	}
}
	
	
}





