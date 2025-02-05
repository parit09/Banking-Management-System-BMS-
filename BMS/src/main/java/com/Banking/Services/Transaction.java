package com.Banking.Services;

public class Transaction {
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
