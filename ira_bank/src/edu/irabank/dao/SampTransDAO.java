package edu.irabank.dao;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;

public interface SampTransDAO {

	AccountDetailsDTO getAccountsDTObyUserID(int userId);

	Boolean RequestDetailsSave(RequestDetailsDTO request);
	
	//for service access
	

}
