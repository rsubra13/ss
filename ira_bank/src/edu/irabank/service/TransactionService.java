package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.AccountDetailsDTO;

public interface TransactionService {

	public boolean CreditBalance(String accountNo, Integer balance);
	public boolean DebitBalance(String accnt, Integer bal);
	public String getAccountNumberbyUserID(Integer Userid);
	public boolean getAccountNumber(String accountNo);
	public boolean TransferBalance(String toAccount, String fromAccount, Integer amount);
	
}
