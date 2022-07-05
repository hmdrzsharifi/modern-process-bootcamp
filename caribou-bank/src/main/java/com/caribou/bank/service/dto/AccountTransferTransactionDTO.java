package com.caribou.bank.service.dto;

import com.caribou.bank.domain.SavingsAccountTransaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class AccountTransferTransactionDTO {

    private SavingsAccountTransaction fromSavingsTransaction;

    private SavingsAccountTransaction toSavingsTransaction;

    private Date date;

    private BigDecimal amount;

    private String description;

    public SavingsAccountTransaction getFromSavingsTransaction() {
        return fromSavingsTransaction;
    }

    public void setFromSavingsTransaction(SavingsAccountTransaction fromSavingsTransaction) {
        this.fromSavingsTransaction = fromSavingsTransaction;
    }

    public SavingsAccountTransaction getToSavingsTransaction() {
        return toSavingsTransaction;
    }

    public void setToSavingsTransaction(SavingsAccountTransaction toSavingsTransaction) {
        this.toSavingsTransaction = toSavingsTransaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
