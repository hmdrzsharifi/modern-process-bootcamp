package com.caribou.bank.service.dto;

import com.caribou.bank.domain.SavingsAccountTransactionType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 * A DTO for the {@link com.caribou.bank.domain.SavingsAccountTransaction} entity.
 */
public class SavingsAccountTransactionDTO implements Serializable {

    //private Long id;

    private SavingsAccountTransactionType transactionType;

    private Date dateOf;

    private BigDecimal amount;

    //private BigDecimal runningBalance;

//    private Long savingsAccountId;

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

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

/*    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }*/

//    public Long getSavingsAccountId() {
//        return savingsAccountId;
//    }
//
//    public void setSavingsAccountId(Long savingsAccountId) {
//        this.savingsAccountId = savingsAccountId;
//    }
}
