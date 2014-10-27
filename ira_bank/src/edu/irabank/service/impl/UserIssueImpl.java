package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.UserIssueDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.form.IssueFormBean;
import edu.irabank.service.RequestService;
@Service
public class UserIssueImpl implements RequestService
{
	
	@Autowired
	private UserIssueDAO userissueDAO;
	
	
	@Override
	@Transactional
	// Register a new User
	public boolean addNewIssue(IssueFormBean IssueFormBean) {
		
		//Date date= new Date();
		RequestDetailsDTO newIssue = new RequestDetailsDTO();
		newIssue.setReqDesc(IssueFormBean.getDescription());
		newIssue.setReqType(IssueFormBean.getIssue());
		System.out.println("comes in 33: User Service ");
	    Boolean issueSubmitted=userissueDAO.addNewIssue(newIssue);
		if(!issueSubmitted) {
			System.out.println("Some issues in Submitting issue, Please try again later!");
			return false;
		}
		
		else{
			// TODO 1. Think about generating an autogen account number here 
			// through acctnumber service or 2. send a notification to admin
			// to accept and assign an acct number for this user.
 			System.out.println("Issue Submitted successfully");
 			return true;
		}
		
		

 }
}
