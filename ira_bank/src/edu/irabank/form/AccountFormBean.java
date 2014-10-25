package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountFormBean {
	
    private int balance;
    private String accountNumber; 
   
    public void setAccountNumber(String accountNumber){
    	this.accountNumber = accountNumber;
    }
	
    public String getAccountNumber(String accountNumber) {
		return accountNumber;
	}
    
	public void setbalance(int balance) {
		this.balance = balance;
	}
	public int getbalance() {
		return balance;
	}
		
    
    
}
