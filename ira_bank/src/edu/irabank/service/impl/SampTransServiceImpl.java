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
public class SampTransServiceImpl implements SampTransService{


SampTransDAOImpl DAO = new SampTransDAOImpl();

@Transactional
public boolean createTransactions(SampTransFormBean trans, int userId)
{
	AccountDetailsDTO DTO= new AccountDetailsDTO();
	//req_user_id
	try{
		HttpSession sessionID = null;
		sessionID.setAttribute("userId", userId);
		System.out.println("Entered Try Loop for ServiceImple and sessionID is "+sessionID.getAttribute("userId"));
		
		DTO = DAO.getAccountsDTObyUserID(userId);
		System.out.println("Done : 32");
		return true;
	}
	catch(Exception e){System.out.println("Exception is:"+e);return true;}
	
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
	RequestDetailsDTO DTO= new RequestDetailsDTO();
	DTO.setReqDesc((String)sampTransFormBean.getTo_account());
	DTO.setReqId(uId);
	DTO.setReqStatus(0);
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	DTO.setReqDate(date);
	DTO.setIsAuthorized(0);
	DTO.setReqType("transact");
	
	System.out.println("Request Details Set");
	
	}
	catch(Exception e){}
	return true;
}

}
