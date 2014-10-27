package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;


public interface AccountDetailsDAO {

	
	public String getAccountNumber(String accountno);
	public int getBalance(String accntno);
	public boolean updateBalance(String accountNo, Integer bal);
	public String getAccountDTOByAccountNumber(String accountNO);

}
