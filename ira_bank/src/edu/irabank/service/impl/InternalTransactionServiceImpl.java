package edu.irabank.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.service.InternalTransactionService;
import edu.irabank.dao.InternalTransactionDAO;
import edu.irabank.dao.RequestDetailsDAO;
import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dao.impl.InternalTransactionImplDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.InternalTransactionFormBean;
/**
 * @author Rakesh Subramanian
 *
 */
@Service
@Transactional
public class InternalTransactionServiceImpl implements InternalTransactionService{

@Autowired
InternalTransactionDAO DAO;

@Autowired
UserDAO userDAO;

@Autowired
TransactionDetailsDAO transDAO;

@Autowired
RequestDetailsDAO requestDAO;





@Override
@Transactional
public boolean createTransactions(InternalTransactionFormBean internalTransactionFormBean, int userId, TransactionDetailsDTO transDTO)
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
		/*if(Integer.parseInt(DTO.getAccountNumber()) != Integer.parseInt(DTO.getAccountNumber())){
			System.out.println("Enter your valid account number! ");//jsp?
			return false;
		}*/
		
		
		accountNoQueryDTO  = DAO.getAccountbyAccountNumber(internalTransactionFormBean.getTo_account());
		if(accountNoQueryDTO==null){System.out.println("Invalid account number!"); return false;}  //how to print in jsp from here?
		else{
			
			/*-------------------------*/
			int balance= DTO.getBalance()-internalTransactionFormBean.getAmount();
			DTO.setBalance(balance);
			accountNoQueryDTO.setBalance(accountNoQueryDTO.getBalance()+internalTransactionFormBean.getAmount());
			
			
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
		RequestDTO.setReqDesc("From"+","+(String)DTO.getAccountNumber()+","+"To"+","+(String)internalTransactionFormBean.getTo_account());
		RequestDTO.setReqId(userId);
		RequestDTO.setReqStatus(0);
		RequestDTO.setReqTransId(transDTO);
		if(internalTransactionFormBean.getAmount()>5000){
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
		return true;
		}
	}
		
		}
	
	catch(Exception e){System.out.println("Exception is:"+e);return false;}
	
	


}

@Override
@Transactional
public boolean setTransactionDetails(InternalTransactionFormBean internalTransactionFormBean,int userId)
{
	
	//send request id from ReqDEtails to TransactionDAO to set transactions
	TransactionDetailsDTO transDTO = new TransactionDetailsDTO();
	AccountDetailsDTO accountDTO = new AccountDetailsDTO();
	accountDTO =DAO.getAccountsDTObyUserID(userId);
	System.out.println("Entered SetRequestDetails");
	String accountNumber =accountDTO.getAccountNumber();
	transDTO.setFromAcct(accountDTO.getAccountNumber());
	System.out.println("Account Number Grab"+accountDTO.getAccountNumber());
	transDTO.setToAcct(internalTransactionFormBean.getTo_account());
	transDTO.setTransAmt(internalTransactionFormBean.getAmount());
	Date date = new Date();
	transDTO.setTransDate(date);
	
	//RequestDetailsSave(RequestDetailsDTO request)
	Boolean isTransSave = transDAO.TransactionDetailsSave(transDTO);
	if(!isTransSave) 
	{
		System.out.println("Some issues in Transaction Save, Please try again later!");
		return false;
	}
		
	

	else{
		createTransactions(internalTransactionFormBean, userId,transDTO);
		System.out.println("Transaction Details Set");
	return true;
	}
	}
/*@Override
@Transactional
public boolean setRequestDetails(InternalTransactionFormBean sampTransFormBean,int uId)
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

@Override
public List<RequestDetailsDTO> listTransactions() {
	List transactionList = requestDAO.listTransactions();
	System.out.println("userList in Service" + transactionList);
	return transactionList;
	
	
	// TODO Auto-generated method stub
	
}

}
