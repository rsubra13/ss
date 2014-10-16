package edu.irabank.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.*;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.UsersDTO;
import edu.irabank.service.UserService;
@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDAOImpl userDAOImplobject;
	
	@Transactional
	public boolean validateUser(String inputUserName, String inputPassword)
	{
		
		String userPassword = userDAOImplobject.retrievePassword(inputUserName);
		System.out.println("User Input Password = " + inputPassword);
		
		// Here actually the Hashed password needs to be checked.
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
	public UsersDTO getUserDTO(String userName)
	{
		return userDAOImplobject.getUserDTO(userName);
	}

}
