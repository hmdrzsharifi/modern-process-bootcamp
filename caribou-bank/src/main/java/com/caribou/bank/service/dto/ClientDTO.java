package com.caribou.bank.service.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.caribou.bank.domain.Client} entity.
 */
public class ClientDTO implements Serializable {

    private Long id;

    @Size(max = 50)
    private String firstname;

    @Size(max = 50)
    private String lastname;

    @Size(max = 50)
    private String middlename;

    @Size(max = 50)
    private String mobileNo;

    @Size(max = 50)
    private String emailAddress;

    @Size(max = 100)
    private String externalId;

    private Date dateOfBirth;

    private Long officeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }
}
