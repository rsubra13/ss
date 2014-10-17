package edu.irabank.dao;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserDAO {

	public String getPassword(String userID);
	public UserDTO getUserDTOByUsername(String userName);
	public Boolean addNewUser(UserDTO userDTO); // Pass user object as an argument

//TODO: Add The following services
	
/*getUserByID - returns UserDTO object
getUserByRole - returns UserDTO Object
addNewUser  - register New User from the details got from UserRegistration Formbean
getAllUsersbyRole  - returns a list of UserDTO objects
deleteUser - returns bool if its deleted ( pass userdto as parameter)
modifyUser - use registerFormBean if not all the User fields are gonna be used
updateLoginAttempts - Use getLoginAttemptCount and setLoginAttemptCount
resetLoginAttempts  -  same*/
//TODO : Add OTP, Number of Login Attempts, isAcctLocked Fields in the DTO of user.


}
