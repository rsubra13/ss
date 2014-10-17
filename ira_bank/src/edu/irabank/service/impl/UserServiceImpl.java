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
	private UserDAOImpl userDAOImplobject;
	
	@Transactional
	public boolean validateUser(String inputUserName, String inputPassword)
	{
		
		String userPassword = userDAOImplobject.getPassword(inputUserName);
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
		return userDAOImplobject.getUserDTOByUsername(userName);
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
		newUser.setRoleId(userRegistrationFormBean.getRole());
		// TODO check here if the user is already present
		
		// Add this newly created UserDTO Object into the DB. 
		
		return false;
		
	}

}
