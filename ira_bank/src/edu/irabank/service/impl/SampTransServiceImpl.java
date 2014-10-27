package edu.irabank.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.service.SampTransService;
import edu.irabank.dao.SampTransDAO;
import edu.irabank.dao.impl.SampTransDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.form.SampTransFormBean;
@Service
@Transactional
public class SampTransServiceImpl implements SampTransService{

@Autowired
SampTransDAO DAO;






@Override
public boolean createTransactions(SampTransFormBean trans, int userId)
{
	
	//req_user_id
	try{
		
		System.out.println("Entered Try Loop for ServiceImple and userId is " + userId);
		AccountDetailsDTO DTO = new AccountDetailsDTO();
		DTO =DAO.getAccountsDTObyUserID(userId);
		System.out.println("-------------Final Value got from DAO!----------------");
		
		System.out.println("Account Number Retreived: "+DTO.getAccountNumber());
		System.out.println("------------------------------------------------------");
		
		
		System.out.println("Done : 32");
		return true;
	}
	catch(Exception e){System.out.println("Exception is:"+e);return false;}
	
	//should return false but true for testing case
	
	
	
	//req_status
	
	
	//req_date


}

@Override
@Transactional
public boolean setRequestDetails(SampTransFormBean sampTransFormBean,int uId)
{
	try{
		System.out.println("Entered SetRequestDetails");
	RequestDetailsDTO RequestDTO= new RequestDetailsDTO();
	RequestDTO.setReqDesc((String)sampTransFormBean.getTo_account());
	RequestDTO.setReqId(uId);
	RequestDTO.setReqStatus(0);
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	RequestDTO.setReqDate(date);
	RequestDTO.setIsAuthorized(0);
	RequestDTO.setReqType("transact");
	//RequestDetailsSave(RequestDetailsDTO request)
	Boolean isRequestSaved = DAO.RequestDetailsSave(RequestDTO);
	if(!isRequestSaved) {
		System.out.println("Some issues in User Registration, Please try again later!");
		return false;
	}
	
	System.out.println("Request Details Set");
	
	}
	catch(Exception e){}
	return true;
}

}
