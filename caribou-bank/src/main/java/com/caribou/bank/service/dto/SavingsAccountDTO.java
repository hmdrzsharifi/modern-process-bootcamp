package com.caribou.bank.service.dto;

import com.caribou.bank.domain.SavingsAccountStatusType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.caribou.bank.domain.SavingsAccount} entity.
 */
public class SavingsAccountDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String accountNumber;

    private String externalId;

    private SavingsAccountStatusType status;

    private BigDecimal nominalAnnualInterestRate;

    private BigDecimal minRequiredOpeningBalance;

    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SavingsAccountStatusType getStatus() {
        return status;
    }

    public void setStatus(SavingsAccountStatusType status) {
        this.status = status;
    }

    public BigDecimal getNominalAnnualInterestRate() {
        return nominalAnnualInterestRate;
    }

    public void setNominalAnnualInterestRate(BigDecimal nominalAnnualInterestRate) {
        this.nominalAnnualInterestRate = nominalAnnualInterestRate;
    }

    public BigDecimal getMinRequiredOpeningBalance() {
        return minRequiredOpeningBalance;
    }

    public void setMinRequiredOpeningBalance(BigDecimal minRequiredOpeningBalance) {
        this.minRequiredOpeningBalance = minRequiredOpeningBalance;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
