package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.AccountDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dao.impl.AccountDAOImpl;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.AccountFormBean;
import edu.irabank.service.AccountService;
import edu.irabank.service.UserService;

@Service
public class AccountServiceImpl implements AccountService
{
	
	@Autowired
	private AccountDAO accountDAO;
	

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public boolean addNewAccount(UserDTO userDTO) {
			
			AccountDetailsDTO newAccount = new AccountDetailsDTO();
			newAccount.setBalance(500); //set default balance to 500
			newAccount.setUId(userDTO); //set userID
			
			
			//Create random acct number
			Random rand = new Random();
			long num = rand.nextInt(900000000) + 100000000;
			
			String accNo = String.valueOf(num);
			
			newAccount.setAccountNumber(accNo); //set the accountNumber		
			
			Boolean isAdded = accountDAO.addNewAccount(newAccount);
			
			return true;
			
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AccountDetailsDTO> listAccounts() {
		// TODO Auto-generated method stub
		List accountsList = accountDAO.listAccounts();
		System.out.println("userList in Service" + accountsList);
		return accountsList;
	}
	
	@Override
	@Transactional
	public void deleteAccount(Integer userID) {
		accountDAO.deleteAccount(userID);
		// TODO Auto-generated method stub
		
	}
	

}
