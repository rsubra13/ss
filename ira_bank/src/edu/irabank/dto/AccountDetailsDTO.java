/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "AccountDetailsDTO.findByAcctId", query = "SELECT a FROM AccountDetailsDTO a WHERE a.accountDetailsDTOPK.acctId = :acctId"),
    @NamedQuery(name = "AccountDetailsDTO.findByAccountNumber", query = "SELECT a FROM AccountDetailsDTO a WHERE a.accountDetailsDTOPK.accountNumber = :accountNumber"),
    @NamedQuery(name = "AccountDetailsDTO.findByBalance", query = "SELECT a FROM AccountDetailsDTO a WHERE a.balance = :balance")})
public class AccountDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountDetailsDTOPK accountDetailsDTOPK;
    @Basic(optional = false)
    @NotNull
    private int balance;
    @JoinColumn(name = "U_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UsersDTO uId;

    public AccountDetailsDTO() {
    }

    public AccountDetailsDTO(AccountDetailsDTOPK accountDetailsDTOPK) {
        this.accountDetailsDTOPK = accountDetailsDTOPK;
    }

    public AccountDetailsDTO(AccountDetailsDTOPK accountDetailsDTOPK, int balance) {
        this.accountDetailsDTOPK = accountDetailsDTOPK;
        this.balance = balance;
    }

    public AccountDetailsDTO(int acctId, String accountNumber) {
        this.accountDetailsDTOPK = new AccountDetailsDTOPK(acctId, accountNumber);
    }

    public AccountDetailsDTOPK getAccountDetailsDTOPK() {
        return accountDetailsDTOPK;
    }

    public void setAccountDetailsDTOPK(AccountDetailsDTOPK accountDetailsDTOPK) {
        this.accountDetailsDTOPK = accountDetailsDTOPK;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public UsersDTO getUId() {
        return uId;
    }

    public void setUId(UsersDTO uId) {
        this.uId = uId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountDetailsDTOPK != null ? accountDetailsDTOPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetailsDTO)) {
            return false;
        }
        AccountDetailsDTO other = (AccountDetailsDTO) object;
        if ((this.accountDetailsDTOPK == null && other.accountDetailsDTOPK != null) || (this.accountDetailsDTOPK != null && !this.accountDetailsDTOPK.equals(other.accountDetailsDTOPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.AccountDetailsDTO[ accountDetailsDTOPK=" + accountDetailsDTOPK + " ]";
    }
    
}
