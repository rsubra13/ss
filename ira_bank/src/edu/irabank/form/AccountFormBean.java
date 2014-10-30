package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountFormBean {
	
    private String amount;
    private String accountNumber;
    private String CreditDebit; 
   
    public void setAccountNumber(String accountNumber){
    	this.accountNumber = accountNumber;
    }
	
    public String getAccountNumber() {
		return accountNumber;
	}
    
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setCreditDebit(String CreditDebit) {
			this.CreditDebit = CreditDebit;
		}
	
    public String getCreditDebit() {
		return CreditDebit;
	}
    
 
		
    
    
}
