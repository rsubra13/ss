package edu.irabank.dao;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;

public interface SampTransDAO {

	AccountDetailsDTO getAccountsDTObyUserID(int userId);

	Boolean RequestDetailsSave(RequestDetailsDTO request);


	AccountDetailsDTO getAccountbyAccountNumber(String accountNumber);

	Boolean AccountDetailsSave(AccountDetailsDTO accountsDTO);
	
	//for service access
	

}
