package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.AccountDetailsDTO;

public interface TransactionService {

	public boolean CreditBalance(String accountNo, Integer balance);
	public boolean DebitBalance(String accnt, Integer bal);
	public boolean getAccountNumber(String accountNo);
	
}
