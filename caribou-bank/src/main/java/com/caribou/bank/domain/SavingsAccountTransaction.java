package com.caribou.bank.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "savings_account_transaction_sequence")
@Table(name = "m_savings_account_transaction")
public class SavingsAccountTransaction extends AbstractPersistableCustom implements Serializable {


    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private SavingsAccountTransactionType transactionType;

    @Column(name = "transaction_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOf;

    @Column(name = "amount", scale = 6, precision = 19, nullable = false)
    private BigDecimal amount;

    @Column(name = "running_balance_derived", scale = 6, precision = 19)
    private BigDecimal runningBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_account_id")
    private SavingsAccount savingsAccount;

    public SavingsAccountTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(SavingsAccountTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDateOf() {
        return dateOf;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
