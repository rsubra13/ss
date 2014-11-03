package edu.irabank.form;

	import java.util.Date;

	import javax.persistence.Basic;
	import javax.persistence.Column;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;

public class ForgotPasswordFormBean {
		
	   
	    private String emailId;
	   
	    private Date dob;
	   
	    private String secQue1;
	    private String secAns1;
	    private String secQue2;
	    private String secAns2;
	    
		
		
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		
		public String getSecQue1() {
			return secQue1;
		}
		public void setSecQue1(String secQue1) {
			this.secQue1 = secQue1;
		}
		public String getSecAns1() {
			return secAns1;
		}
		public void setSecAns1(String secAns1) {
			this.secAns1 = secAns1;
		}
		public String getSecQue2() {
			return secQue2;
		}
		public void setSecQue2(String secQue2) {
			this.secQue2 = secQue2;
		}
		public String getSecAns2() {
			return secAns2;
		}
		public void setSecAns2(String secAns2) {
			this.secAns2 = secAns2;
		}
		
	    
	    
	}

