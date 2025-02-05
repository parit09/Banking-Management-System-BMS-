package com.Banking.Database;
import java.util.ArrayList;

import com.Banking.Models.Employee;
import com.Banking.Models.User;
import com.Banking.Services.Accounts;
import com.Banking.Services.Loan;
import com.Banking.Services.Transaction;

public class Database {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Accounts> accounts = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Loan> loans = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Accounts> getAccounts() {
        return accounts;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static ArrayList<Loan> getLoans() {
        return loans;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static boolean userExists(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public static void addAccount(Accounts account) {
        accounts.add(account);
    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static void addLoan(Loan loan) {
        loans.add(loan);
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static Accounts findAccount(String accountNumber) {
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public static void deposit(String accountNumber, double amount) {
        Accounts acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Error: Account not found.");
        } else {
            acc.deposit(amount);
        }
    }
}
