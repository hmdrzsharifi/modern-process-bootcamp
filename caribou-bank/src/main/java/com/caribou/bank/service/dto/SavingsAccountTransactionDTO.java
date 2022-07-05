package com.caribou.bank.service.dto;

import com.caribou.bank.domain.SavingsAccountTransactionType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SavingsAccountTransactionDTO implements Serializable {

    private SavingsAccountTransactionType transactionType;

    private Date dateOf;

    private BigDecimal amount;

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
}
