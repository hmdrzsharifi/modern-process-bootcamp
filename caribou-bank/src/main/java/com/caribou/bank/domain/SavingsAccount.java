package com.caribou.bank.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The SavingsAccount entity.
 */
@Entity
@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "savings_account_sequence")
@Table(name = "m_savings_account")
public class SavingsAccount extends AbstractPersistableCustom implements Serializable {

    @Column(name = "account_no", length = 20, nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SavingsAccountStatusType status;

    @Column(name = "nominal_annual_interest_rate", scale = 6, precision = 19, nullable = false)
    private BigDecimal nominalAnnualInterestRate;

    @Column(name = "min_required_opening_balance", scale = 6, precision = 19, nullable = true)
    private BigDecimal minRequiredOpeningBalance;

    @Column(name = "account_balance_derived", scale = 6, precision = 19)
    @ColumnDefault("0")
    private BigDecimal accountBalance = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
