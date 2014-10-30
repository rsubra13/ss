package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.AccountDetailsDTO;

public interface TransactionService {

	public String getAccountNumberbyUserID(Integer Userid);
	public boolean getAccountNumber(String accountNo);
	boolean CreditBalance(String inputAccountNo, Double inputbalance);
	boolean DebitBalance(String inputAccNo, Double inputbal);
	boolean TransferBalance(String toAccount, String fromAccount,Double inputbal);
	boolean BillPay(String AccountNo, Double balance, String Status);
	
	
}
