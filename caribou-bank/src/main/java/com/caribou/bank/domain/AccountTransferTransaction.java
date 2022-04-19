package com.caribou.bank.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m_account_transfer_transaction")
public class AccountTransferTransaction extends AbstractPersistableCustom implements Serializable {

    @ManyToOne
    @JoinColumn(name = "from_savings_transaction_id")
    private SavingsAccountTransaction fromSavingsTransaction;

    @ManyToOne
    @JoinColumn(name = "to_savings_transaction_id")
    private SavingsAccountTransaction toSavingsTransaction;

    @Temporal(TemporalType.DATE)
    @Column(name = "transaction_date")
    private Date date;

    @Column(name = "amount", scale = 6, precision = 19, nullable = false)
    private BigDecimal amount;

    @Column(name = "description", length = 100)
    private String description;

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
}
