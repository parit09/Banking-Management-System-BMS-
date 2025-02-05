package com.Banking.BMS;
import java.util.Scanner;

import com.Banking.Database.Database;
import com.Banking.Models.Customer;
import com.Banking.Models.Employee;
import com.Banking.Services.Accounts;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Employee admin = new Employee("Admin", "E001", "Manager");
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
                    
                    System.out.print("\u001B[33mIs this user an Employee? (yes/no): \u001B[0m");
                    String userType = scanner.nextLine();
                    
                    if (userType.equalsIgnoreCase("yes")) {
                        System.out.print("\u001B[33mEnter Employee ID: \u001B[0m");
                        String empId = scanner.nextLine();
                        Database.addEmployee(new Employee(name, userId, empId));
                        System.out.println("Employee created successfully!");
                    } else {
                        Database.addUser(new Customer(name, userId));
                        System.out.println("Customer created successfully!");
                    }
                    break;
                
                case 2:
                    System.out.print("\u001B[33mEnter user ID: \u001B[0m");
                    String accUserId = scanner.nextLine();
                    if (!Database.userExists(accUserId)) {
                        System.out.println("Error: User does not exist. Create a user first.");
                        break;
                    }
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    String accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter initial balance: \u001B[0m");
                    double balance = scanner.nextDouble();
                    Database.addAccount(new Accounts(accNum, balance, accUserId));
                    System.out.println("Account created successfully!");
                    break;
                
                case 3:
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter deposit amount: \u001B[0m");
                    double deposit = scanner.nextDouble();
                    Database.deposit(accNum, deposit);
                    Accounts depAccount = Database.findAccount(accNum);
                    if (depAccount != null) {
                        System.out.println("Current balance: " + depAccount.getBalance());
                    }
                    break;
                
                case 4:
                    System.out.print("\u001B[33mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[33mEnter withdrawal amount: \u001B[0m");
                    double withdraw = scanner.nextDouble();
                    
                    Accounts acc = Database.findAccount(accNum);
                    if (acc != null) {
                        if (acc.getBalance() - withdraw < 500) {  // Minimum balance threshold
                            System.out.println("Error: Minimum balance of 500 must be maintained.");
                        } else {
                            acc.withdraw(withdraw);
                            System.out.println("Current balance: " + acc.getBalance());
                        }
                    } else {
                        System.out.println("Error: Account not found.");
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
