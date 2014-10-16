package edu.irabank.service;

import edu.irabank.dto.UsersDTO;

public interface UserService {

	public boolean validateUser(String userName, String password);
	
	public UsersDTO getUserDTO(String userName);

}
