/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "request_details", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestDetailsDTO.findAll", query = "SELECT r FROM RequestDetailsDTO r"),
    @NamedQuery(name = "RequestDetailsDTO.findByReqId", query = "SELECT r FROM RequestDetailsDTO r WHERE r.reqId = :reqId"),
    @NamedQuery(name = "RequestDetailsDTO.findByReqDesc", query = "SELECT r FROM RequestDetailsDTO r WHERE r.reqDesc = :reqDesc"),
    @NamedQuery(name = "RequestDetailsDTO.findByReqStatus", query = "SELECT r FROM RequestDetailsDTO r WHERE r.reqStatus = :reqStatus"),
    @NamedQuery(name = "RequestDetailsDTO.findByReqDate", query = "SELECT r FROM RequestDetailsDTO r WHERE r.reqDate = :reqDate"),
    @NamedQuery(name = "RequestDetailsDTO.findByReqType", query = "SELECT r FROM RequestDetailsDTO r WHERE r.reqType = :reqType"),
    @NamedQuery(name = "RequestDetailsDTO.findByIsAuthorized", query = "SELECT r FROM RequestDetailsDTO r WHERE r.isAuthorized = :isAuthorized")})
public class RequestDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REQ_ID")
    private Integer reqId;
    @Size(max = 90)
    @Column(name = "REQ_DESC")
    private String reqDesc;
    @Column(name = "REQ_STATUS")
    private Integer reqStatus;
    @Column(name = "REQ_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDate;
    @Size(max = 25)
    @Column(name = "REQ_TYPE")
    private String reqType;
    @Column(name = "IS_AUTHORIZED")
    private Integer isAuthorized;
    @JoinColumn(name = "REQ_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserDTO reqUserId;

    public RequestDetailsDTO() {
    }

    public RequestDetailsDTO(Integer reqId) {
        this.reqId = reqId;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getReqDesc() {
        return reqDesc;
    }

    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc;
    }

    public Integer getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(Integer reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public Integer getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(Integer isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public UserDTO getReqUserId() {
        return reqUserId;
    }

    public void setReqUserId(UserDTO reqUserId) {
        this.reqUserId = reqUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqId != null ? reqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestDetailsDTO)) {
            return false;
        }
        RequestDetailsDTO other = (RequestDetailsDTO) object;
        if ((this.reqId == null && other.reqId != null) || (this.reqId != null && !this.reqId.equals(other.reqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.RequestDetailsDTO[ reqId=" + reqId + " ]";
    }
    
}