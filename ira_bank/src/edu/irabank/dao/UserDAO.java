package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserDAO {

	public String getPassword(String userID);
	public UserDTO getUserDTOByUsername(String userName);
	public UserDTO getUserDTOByUserId(Integer userId);
	public Boolean addNewUser(UserDTO userDTO); // Pass user object as an argument
	public List<UserDTO> listUsers();
	public void deleteUser(Integer userId);
	public Boolean updateUserDetails(UserDTO userDTO);



}
