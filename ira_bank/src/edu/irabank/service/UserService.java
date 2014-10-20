package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserService {

	// Login check
	public boolean validateUser(String userName, String password);
	public UserDTO getUserDTOByUsername(String userName);
	
	// Register User
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean);

	//Update User details
	public void updateUserDetails(UserDTO userDTO);

	//Get User(s) info
	public List<UserDTO> listUsers();
	public UserDTO getUserinfo(Integer userId); // single user DTO

    //Delete User
	public void deleteUser(Integer userId);
	
	
    
	
/*
//TODO getUserByID - returns UserDTO object
getUserByRole - returns UserDTO Object
getAllUsersbyRole  - returns a list of UserDTO objects
updateLoginAttempts - Use getLoginAttemptCount and setLoginAttemptCount
resetLoginAttempts  -  same
accessLogFile();

*/
	
}
