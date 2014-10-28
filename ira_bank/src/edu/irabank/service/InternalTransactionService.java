package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.form.InternalTransactionFormBean;

public interface InternalTransactionService {

	
	
	boolean createTransactions(InternalTransactionFormBean internalTransactionFormBean, int userId,
			TransactionDetailsDTO transDTO);

	boolean setTransactionDetails(InternalTransactionFormBean internalTransactionFormBean,
			int userId);

	List<RequestDetailsDTO> listTransactions();



	//boolean setRequestDetails(InternalTransactionFormBean sampTransFormBean, int userId);
}
