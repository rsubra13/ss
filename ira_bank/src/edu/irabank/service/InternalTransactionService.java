package edu.irabank.service;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.form.InternalTransactionFormBean;

public interface InternalTransactionService {

	
	
	boolean createTransactions(InternalTransactionFormBean internalTransactionFormBean, int userId,
			TransactionDetailsDTO transDTO);

	boolean setTransactionDetails(InternalTransactionFormBean internalTransactionFormBean,
			int userId);



	//boolean setRequestDetails(InternalTransactionFormBean sampTransFormBean, int userId);
}
