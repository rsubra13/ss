package edu.irabank.dao;

import edu.irabank.dto.UserDTO;

public interface UserDAO {

	public String retrievePassword(String userID);
	
	public UserDTO getUserDTO(String userName);


}
