package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TransferFormBean {
	
    private String fromaccount;
    private String toaccount; 
    private String amount;
    private String pki;
   
    public void setFromaccount(String fromaccount){
    	this.fromaccount = fromaccount;
    }
	
    public String getFromaccount() {
		return fromaccount;
	}
    
    public void setToaccount(String toaccount){
    	this.toaccount = toaccount;
    }
	
    public String getToaccount() {
		return toaccount;
	}
    
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setPki(String pki) {
		this.pki = pki;
	}
	
	public String getPki() {
		return pki;
	}
			
    
    
}
