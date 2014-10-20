/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "account_details", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetailsDTO.findAll", query = "SELECT a FROM AccountDetailsDTO a"),
    @NamedQuery(name = "AccountDetailsDTO.findByAcctId", query = "SELECT a FROM AccountDetailsDTO a WHERE a.acctId = :acctId"),
    @NamedQuery(name = "AccountDetailsDTO.findByAccountNumber", query = "SELECT a FROM AccountDetailsDTO a WHERE a.accountNumber = :accountNumber"),
    @NamedQuery(name = "AccountDetailsDTO.findByUId", query = "SELECT a FROM AccountDetailsDTO a WHERE a.uId = :uId"),
    @NamedQuery(name = "AccountDetailsDTO.findByBalance", query = "SELECT a FROM AccountDetailsDTO a WHERE a.balance = :balance")})
public class AccountDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ACCT_ID")
    private Integer acctId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "U_ID")
    private Integer uId;
    @Basic(optional = false)
    @NotNull
    private int balance;
    @JoinColumn(name = "ACCT_ID", referencedColumnName = "ACCT_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserDTO userDTO;

    public AccountDetailsDTO() {
    }

    public AccountDetailsDTO(Integer acctId) {
        this.acctId = acctId;
    }

    public AccountDetailsDTO(Integer acctId, String accountNumber, int balance) {
        this.acctId = acctId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acctId != null ? acctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetailsDTO)) {
            return false;
        }
        AccountDetailsDTO other = (AccountDetailsDTO) object;
        if ((this.acctId == null && other.acctId != null) || (this.acctId != null && !this.acctId.equals(other.acctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.AccountDetailsDTO[ acctId=" + acctId + " ]";
    }
    
}
