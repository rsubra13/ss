package edu.irabank.service;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserService {

	public boolean validateUser(String userName, String password);
	public UserDTO getUserDTOByUsername(String userName);
	//TODO : Many other services I have referred in ServicesIMPL
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean);
}
