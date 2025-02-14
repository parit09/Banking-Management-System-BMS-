package com.Banking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
    private String transactionId;
    private String accountNumber;
    private double amount;
    private String type;

    public Transaction(String transactionId, String accountNumber, double amount, String type) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
