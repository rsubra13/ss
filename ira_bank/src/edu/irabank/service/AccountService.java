package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.AccountFormBean;


public interface AccountService {

	public boolean addNewAccount(Integer userID);
	
	public void deleteAccount(Integer accountID);
	
	public List<AccountDetailsDTO> listAccounts();
	/*createAccountInfo(); - to create account details for a newly registered user. ( default bal , randowmm acct number)
	delAcct()
	modifyAcct()
	viewAccountDetails();
	checkBalance(); 
	accessPII();
	
	//TODO Functionalities:
	techincalAccountAccess(); - full acct access, with privileges. - FOR TROUBLESHOOT
	transactionAccess();   - limited acct (pii )access (ex acct no and name) - authorizing trans / reviewing the trans
	*/
	
}
