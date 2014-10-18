package edu.irabank.service.impl; 

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.UserDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;
import edu.irabank.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserDAO userDAO;

/*	@Autowired
	private UserDAOImpl userDAOImplobject;*/
	
	@Transactional
	public boolean validateUser(String inputUserName, String inputPassword)
	{
		
		String userPassword = userDAO.getPassword(inputUserName);
		System.out.println("User Input Password = " + inputPassword);
		
		//TODO: Here actually the Hashed password needs to be checked.
		if(!userPassword.isEmpty())
		{
			if(userPassword.equals(inputPassword))
			{
				return true;
			}
		}
		return false;
	}

	@Transactional
	public UserDTO getUserDTOByUsername(String userName)
	{
		return userDAO.getUserDTOByUsername(userName);
	}

	@Override
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean) {
		
		UserDTO newUser = new UserDTO();
		newUser.setFirstName(userRegistrationFormBean.getFirstName());
		newUser.setLastName(userRegistrationFormBean.getLastName());
		newUser.setContactNum(userRegistrationFormBean.getContactNum());
		newUser.setAddress(userRegistrationFormBean.getAddress());
		newUser.setUserName(userRegistrationFormBean.getUserName());
		BCryptPasswordEncoder bcrypt = new  BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(userRegistrationFormBean.getPassword());
		newUser.setPassword(encryptedPassword);
		newUser.setDob(userRegistrationFormBean.getDob());
		newUser.setEmailId(userRegistrationFormBean.getEmailId());
		newUser.setDob(userRegistrationFormBean.getDob());
		newUser.setSecAns1(userRegistrationFormBean.getSecAns1());
		newUser.setSecAns2(userRegistrationFormBean.getSecAns2());
		newUser.setSecQue1(userRegistrationFormBean.getSecQue1());
		newUser.setSecQue2(userRegistrationFormBean.getSecQue2());
		
		// TODO : this is not the way to go ahead with Roles.
		// Check if the User is Regular user , then assign him the ROLE_USER
		// Check if the User is a Merchant , assign him the ROLE_MERCHANT
		// This needs spring security?  check it. 
		newUser.setRoleId(userRegistrationFormBean.getRole());
		
		
		// TODO check here if the user is already present
		
		// Add this newly created UserDTO Object into the DB. 
		Boolean isUserRegisted = userDAO.addNewUser(newUser);
		if(!isUserRegisted) {
			System.out.println("Some issues in User Registration");
			return false;
		}
		
		else{
			// TODO 1. Think about generating an autogen account number here 
			// through acctnumber service or 2. send a notification to admin
			// to accept and assign an acct number for this user.
 			System.out.println("User registered");
 			return true;
		}
		
	}

}
