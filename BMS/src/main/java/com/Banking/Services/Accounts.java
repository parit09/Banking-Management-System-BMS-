package com.Banking.Services;

public class Accounts {
    private String accountNumber;
    private double balance;
    private String accountId;

    public Accounts(String accountNumber, double balance,String accID) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        accountId=accID;
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
