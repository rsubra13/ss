package edu.irabank.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.UserDAO;

/**
 * @author Ishaan Sharma
 *
 */


//@Component("authenticationProvider")
@Service
public class LimitLoginServiceImpl extends DaoAuthenticationProvider {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public Authentication authenticate(Authentication auth) 
          throws AuthenticationException {
		
		try{
			Authentication request = super.authenticate(auth);
			System.out.println("comes in rest fail attempts");
			userDAO.resetFailAttempts(auth.getName()); //gets userName
			
		
			return request;	
		}
		catch(BadCredentialsException exception)
		{
			userDAO.updateFailAttempts(auth.getName());
			System.out.println("update fail attempts over");
			//throw exception;
			
		}
		catch(LockedException exception)
		{
			String message = "";
			Integer attempts = userDAO.getLoginAttempts(auth.getName()); 
			if(attempts == 4)
			{
				message = "Account for"+auth.getName()+"is locked ";
			}
			else
			{
				message = exception.getMessage();
			}
			
			 throw new LockedException(message);
		}
		return null;
		
		
	}
}


