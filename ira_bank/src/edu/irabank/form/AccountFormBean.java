package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountFormBean {
	
    private int amount;
    private String accountNumber;
    private String CreditDebit; 
   
    public void setAccountNumber(String accountNumber){
    	this.accountNumber = accountNumber;
    }
	
    public String getAccountNumber() {
		return accountNumber;
	}
    
	public void setbalance(int amount) {
		this.amount = amount;
	}
	public int getbalance() {
		return amount;
	}
	
    public String getCreditDebit() {
		return CreditDebit;
	}
    
    public void setCreditDebit(String CreditDebit) {
		this.CreditDebit = CreditDebit;
	}
		
    
    
}
