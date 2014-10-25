package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;


public interface AccountDetailsDAO {

	
	public String getAccountNumber(String accountno);
	public int getBalance(int balance);
	public boolean creditBalance(String accountNo, int bal);

}
