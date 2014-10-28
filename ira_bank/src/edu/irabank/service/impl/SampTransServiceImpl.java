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
import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dao.impl.SampTransDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.SampTransFormBean;
/**
 * @author Rakesh Subramanian
 *
 */
@Service
@Transactional
public class SampTransServiceImpl implements SampTransService{

@Autowired
SampTransDAO DAO;

@Autowired
UserDAO userDAO;

@Autowired
TransactionDetailsDAO transDAO;






@Override
@Transactional
public boolean createTransactions(SampTransFormBean sampTransFormBean, int userId)
{
	
	//req_user_id
	try{
		
		System.out.println("Entered Try Loop for ServiceImple and userId is " + userId);
		AccountDetailsDTO DTO = new AccountDetailsDTO();
		DTO =DAO.getAccountsDTObyUserID(userId);
		System.out.println("-------------Final Value got from DAO!----------------");
		
		System.out.println("Account Number Retreived: "+DTO.getAccountNumber());
		System.out.println("------------------------------------------------------");
		AccountDetailsDTO accountNoQueryDTO = new AccountDetailsDTO();
		if(Integer.parseInt(sampTransFormBean.getFrom_account()) != Integer.parseInt(DTO.getAccountNumber())){
			System.out.println("Enter your valid account number! ");//jsp?
			return false;
		}
		
		
		accountNoQueryDTO  = DAO.getAccountbyAccountNumber(sampTransFormBean.getTo_account());
		if(accountNoQueryDTO==null){System.out.println("Invalid account number!"); return false;}  //how to print in jsp from here?
		else{
			
			/*-------------------------*/
			int balance= DTO.getBalance()-sampTransFormBean.getAmount();
			DTO.setBalance(balance);
			accountNoQueryDTO.setBalance(accountNoQueryDTO.getBalance()+sampTransFormBean.getAmount());
			
			
			Boolean isAccountsSave = DAO.AccountDetailsSave(DTO);
			if(!isAccountsSave) 
			{
				System.out.println("Some issues in User Registration, Please try again later!");
				return false;
			}
			
			
			/*-------------------------*/
		
		System.out.println("Done : 32");
		
		//setting Request Details Table
		UserDTO userDTO = new UserDTO();
		userDTO = userDAO.getUserDTOByUserId(userId);
		System.out.println("Entered SetRequestDetails");
		RequestDetailsDTO RequestDTO= new RequestDetailsDTO();
		RequestDTO.setReqUserId(userDTO);
		RequestDTO.setReqDesc("From"+","+(String)sampTransFormBean.getFrom_account()+","+"To"+","+(String)sampTransFormBean.getTo_account());
		RequestDTO.setReqId(userId);
		RequestDTO.setReqStatus(0);
		if(sampTransFormBean.getAmount()>5000){
			RequestDTO.setReqPriority("High");
			
		}
		Date date = new Date();
		RequestDTO.setReqDate(date);
		RequestDTO.setIsAuthorized(0);
		RequestDTO.setReqType("Transact");
		//RequestDetailsSave(RequestDetailsDTO request)
		Boolean isRequestSaved = DAO.RequestDetailsSave(RequestDTO);
		if(!isRequestSaved) 
		{
			System.out.println("Some issues in User Registration, Please try again later!");
			return false;
		}
			
		
	
		else{System.out.println("Request Details Set");
		setTransactionDetails(sampTransFormBean,RequestDTO.getReqId());
		return true;
		}
	}
		
		}
	
	catch(Exception e){System.out.println("Exception is:"+e);return false;}
	
	


}

@Override
@Transactional
public boolean setTransactionDetails(SampTransFormBean sampTransFormBean,int reqId)
{
	
	//send request id from ReqDEtails to TransactionDAO to set transactions
	TransactionDetailsDTO transDTO = new TransactionDetailsDTO();
	System.out.println("Entered SetRequestDetails");
	transDTO.setTransId(reqId);
	transDTO.setFromAcct(sampTransFormBean.getFrom_account());
	transDTO.setToAcct(sampTransFormBean.getTo_account());
	transDTO.setTransAmt(sampTransFormBean.getAmount());
	Date date = new Date();
	transDTO.setTransDate(date);
	
	//RequestDetailsSave(RequestDetailsDTO request)
	Boolean isTransSave = transDAO.TransactionDetailsSave(transDTO);
	if(!isTransSave) 
	{
		System.out.println("Some issues in Transaction Save, Please try again later!");
		return false;
	}
		
	

	else{System.out.println("Transaction Details Set");
	return true;
	}
	}
/*@Override
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
}*/

}
