package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationFormBean {
	
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
    private String userName;
	
    private String password;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
	private String firstName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String emailId;
    @Size(max = 560)
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @NotNull
    @Size(min = 1, max = 20)
    private String contactNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String secQue1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String secAns1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String secQue2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String secAns2;
    private Integer role;
    
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
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
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
    
    
}
