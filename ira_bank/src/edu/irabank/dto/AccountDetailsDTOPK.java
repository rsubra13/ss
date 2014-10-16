/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ramki Subramanian
 */
@Embeddable
public class AccountDetailsDTOPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ACCT_ID")
    private int acctId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    public AccountDetailsDTOPK() {
    }

    public AccountDetailsDTOPK(int acctId, String accountNumber) {
        this.acctId = acctId;
        this.accountNumber = accountNumber;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) acctId;
        hash += (accountNumber != null ? accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetailsDTOPK)) {
            return false;
        }
        AccountDetailsDTOPK other = (AccountDetailsDTOPK) object;
        if (this.acctId != other.acctId) {
            return false;
        }
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.AccountDetailsDTOPK[ acctId=" + acctId + ", accountNumber=" + accountNumber + " ]";
    }
    
}
