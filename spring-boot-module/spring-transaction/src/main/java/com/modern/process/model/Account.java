package com.modern.process.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "amount")
  private BigDecimal amount;

  public Account(String name, BigDecimal amount) {
    this.name = name;
    this.amount = amount;
  }

  public Account() {

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
