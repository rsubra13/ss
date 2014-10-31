package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.AccountFormBean;


public interface AccountService {

	public boolean addNewAccount(UserDTO userDTO);
	
	public void deleteAccount(Integer userID);
	
	public List<AccountDetailsDTO> listAccounts();
	
	public AccountDetailsDTO showAccountInfo(Integer UserId);
	/*
	delAcct() 
	accessPII();
	
	//TODO Functionalities:
	techincalAccountAccess(); - full acct access, with privileges. - FOR TROUBLESHOOT
	transactionAccess();   - limited acct (pii )access (ex acct no and name) - authorizing trans / reviewing the trans
	*/
	
}
