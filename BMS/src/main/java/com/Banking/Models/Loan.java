package com.Banking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loan {
	@Id
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
