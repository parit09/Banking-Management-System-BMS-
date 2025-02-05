package com.Banking.BMS;
import java.util.Scanner;

import com.Banking.Database.Database;
import com.Banking.Models.Customer;
import com.Banking.Models.Employee;
import com.Banking.Services.Accounts;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Employee admin = new Employee("E001", "Admin", "Manager");
        Database.addEmployee(admin);

        System.out.println("\u001B[33mWelcome to Banking Management System\u001B[0m");
        
        while (true) {
            System.out.println("\u001B[33m1. Create User\u001B[0m");
            System.out.println("\u001B[33m2. Create Account\u001B[0m");
            System.out.println("\u001B[33m3. Deposit Money\u001B[0m");
            System.out.println("\u001B[33m4. Withdraw Money\u001B[0m");
            System.out.println("\u001B[33m5. Exit\u001B[0m");
            System.out.print("\u001B[33mEnter choice: \u001B[0m");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("\u001B[33mEnter user name: \u001B[0m");
                    String name = scanner.nextLine();
                    System.out.print("\u001B[33mEnter user ID: \u001B[0m");
                    String userId = scanner.nextLine();
                    Customer user = new Customer(name, userId);
                    Database.addUser(user);
                    System.out.println("User created successfully!");
                    break;
                case 2:
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    String accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter initial balance: \u001B[0m");
                    double balance = scanner.nextDouble();
                    Database.addAccount(new Accounts(accNum, balance));
                    System.out.println("Account created successfully!");
                    break;
                case 3:
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter deposit amount: \u001B[0m");
                    double deposit = scanner.nextDouble();
                    for (Accounts acc : Database.getAccounts()) {
                        if (acc.getAccountNumber().equals(accNum)) {
                            acc.deposit(deposit);
                            System.out.println("Deposit successful!");
                        }
                    }
                    break;
                case 4:
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter withdrawal amount: \u001B[0m");
                    double withdraw = scanner.nextDouble();
                    for (Accounts acc : Database.getAccounts()) {
                        if (acc.getAccountNumber().equals(accNum)) {
                            try {
                                acc.withdraw(withdraw);
                                System.out.println("Withdrawal successful!");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("\u001B[33mThank you for using the Banking Management System!\u001B[0m");
                    scanner.close();
                    return;
                default:
                    System.out.println("\u001B[33mInvalid choice, please try again.\u001B[0m");
            }
        }
    }
}
