package edu.irabank.service;

import edu.irabank.dto.UserDTO;

public interface UserService {

	public boolean validateUser(String userName, String password);
	
	public UserDTO getUserDTO(String userName);

}
