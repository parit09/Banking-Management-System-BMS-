package com.Banking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Accounts {
	@Id
    private String accountNumber;
    private double balance;
    
    private String accUserID;

    public Accounts(String accountNumber, double balance,String accUserID) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accUserID=accUserID;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current balance: " + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current balance: " + balance);
        }
    }
}

