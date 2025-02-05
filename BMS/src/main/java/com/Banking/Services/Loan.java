package com.Banking.Services;

public class Loan {
    private String loanId;
    private String userId;
    private double amount;
    private double interestRate;

    public Loan(String loanId, String userId, double amount, double interestRate) {
        this.loanId = loanId;
        this.userId = userId;
        this.amount = amount;
        this.interestRate = interestRate;
    }
}
