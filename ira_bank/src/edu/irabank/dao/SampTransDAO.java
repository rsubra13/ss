package edu.irabank.dao;

import edu.irabank.dto.AccountDetailsDTO;

public interface SampTransDAO {

	AccountDetailsDTO getAccountsDTObyUserID(int userId);
	
	//for service access
	

}
