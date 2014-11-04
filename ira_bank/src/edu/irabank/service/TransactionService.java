package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.BillPayDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.AccountDetailsDTO;

public interface TransactionService {

	public String getAccountNumberbyUserID(Integer Userid);
	public boolean getAccountNumber(String accountNo);
	boolean CreditBalance(String inputAccountNo, Double inputbalance);
	boolean DebitBalance(String inputAccNo, Double inputbal);
	boolean TransferBalance(String toAccount, String fromAccount,Double inputbal);
	boolean BillPay(String AccountNo, Double balance, String Status);
	public List <BillPayDTO> showBillpayInfo();
	boolean BillPayUpdate(Integer billid, String Status);
	boolean BillpayUpdatekey(Integer billid, String hashedkey);
	
	
}
