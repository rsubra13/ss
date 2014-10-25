package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.TransactionDetailsDTO;

public interface TransactionService {

	//TODO : ADD THE FOLLOWING SERVICES
	
/*bool createTransactions(Trans DTO)
 bool modifyTransactions(trans DTO)
 void delTransactions(UserName/UserID)
 List<TransDTO> viewTransactions(Username/UserID)
 bool authorizeTransactions(trans ID) - admin

 // Functionalities:
  
  creditBalance(Acct no, bal)
  debitBalance(Acct no, bal)
  transfer(From Acct, to ACCT, BAL)
  billPay();
  

*/
	
	public boolean CreditBalance(String accountNo, int balance);
	
	
}
