/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.irabank.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ramki
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "UserDTO.findAll", query = "SELECT u FROM UserDTO u"),
    @NamedQuery(name = "UserDTO.findByUserId", query = "SELECT u FROM UserDTO u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDTO.findByEmailId", query = "SELECT u FROM UserDTO u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserDTO.findByUserName", query = "SELECT u FROM UserDTO u WHERE u.userName = :userName"),
     @NamedQuery(name = "UserDTO.findByCreatedOn", query = "SELECT u FROM UserDTO u WHERE u.createdOn = :createdOn"),
    @NamedQuery(name = "UserDTO.findByPassword", query = "SELECT u FROM UserDTO u WHERE u.password = :password")
})


public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "EMAIL_ID")
    private String emailId;
    
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
  

    public UserDTO() {
    }

    // constructor 1
    public UserDTO(Integer userId) {
        this.userId = userId;
    }
     
     // constructor 2
    public UserDTO(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }

   
     public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


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

     public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDTO)) {
            return false;
        }
        UserDTO other = (UserDTO) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.UserDTO[userId=" + userId + "]";
    }

}
