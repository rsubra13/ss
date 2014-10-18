package edu.irabank.service;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserService {

	public boolean validateUser(String userName, String password);
	public UserDTO getUserDTOByUsername(String userName);
	//TODO : Many other services I have referred in ServicesIMPL
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean);

	
/*getUserByID - returns UserDTO object
getUserByRole - returns UserDTO Object
addNewUser  - register New User from the details got from UserRegistration Formbean
getAllUsersbyRole  - returns a list of UserDTO objects
deleteUser - returns bool if its deleted ( pass userdto as parameter)
modifyUser - use registerFormBean if not all the User fields are gonna be used
updateLoginAttempts - Use getLoginAttemptCount and setLoginAttemptCount
resetLoginAttempts  -  same
//TODO : Add OTP, Number of Login Attempts, isAcctLocked Fields in the DTO of user.
accessLogFile();

// TODO security features
 PKI
 OTP

*/
}
