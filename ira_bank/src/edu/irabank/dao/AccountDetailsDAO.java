package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;


public interface AccountDetailsDAO {

	public int getBalance(String accntno);
	public boolean updateBalance(String accountNo, Integer bal);
	public boolean getAccountNum(String accountNO);
	public String getAccountNumbyUserID(Integer Userid);

}
