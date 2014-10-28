package edu.irabank.service;

import edu.irabank.form.SampTransFormBean;

public interface SampTransService {

	
	boolean createTransactions(SampTransFormBean trans, int userId);

	boolean setTransactionDetails(SampTransFormBean sampTransFormBean, int uId);



	//boolean setRequestDetails(SampTransFormBean sampTransFormBean, int userId);
}
