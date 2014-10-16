package edu.irabank.dao;

import edu.irabank.dto.UsersDTO;

public interface UserDAO {

	public String retrievePassword(String userID);
	
	public UsersDTO getUserDTO(String userName);


}
