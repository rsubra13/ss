package edu.irabank.service;

import edu.irabank.form.SampTransFormBean;

public interface SampTransService {

	
	boolean createTransactions(SampTransFormBean trans, int userId);



	boolean setRequestDetails(SampTransFormBean sampTransFormBean, int userId);
}
