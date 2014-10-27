package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.form.IssueFormBean;

public interface UserIssueDAO {
	
	public Boolean addNewIssue(RequestDetailsDTO requestdetailsdto); // Pass user object as an argument
	



}
