package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BillpaymerchantFormBean {
	
    private String account;
    private double amount;

   
    public void setAccount(String account){
    	this.account = account;
    }
	
    public String getAccount() {
		return account;
	}
    
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
			
    
    
}
