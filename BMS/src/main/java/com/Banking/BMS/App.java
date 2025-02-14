package com.Banking.BMS;
import java.util.Scanner;

import com.Banking.Database.Database;
import com.Banking.Models.Accounts;
import com.Banking.Models.Customer;
import com.Banking.Models.Employee;
import com.Banking.Services.AccountServices;
import com.Banking.Services.CustomerServices;
import com.Banking.Services.EmployeeServices;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Employee admin = new Employee("Admin", "E001", "Manager");
        Database.addEmployee(admin);

        System.out.println("\u001B[36mWelcome to Banking Management System\u001B[0m");
        int l=0;
        
        while (l==0) {
            System.out.println("\u001B[36m1. Create User\u001B[0m");
            System.out.println("\u001B[36m2. Create Account\u001B[0m");
            System.out.println("\u001B[36m3. Deposit Money\u001B[0m");
            System.out.println("\u001B[36m4. Withdraw Money\u001B[0m");
            System.out.println("\u001B[36m5. Account Services\u001B[0m");
            System.out.println("\u001B[36m6. Employee Services\u001B[0m");
            System.out.println("\u001B[36m7. Customer Services\u001B[0m");
            System.out.println("\u001B[36m8. Exit\u001B[0m");
            System.out.print("\u001B[36mEnter choice: \u001B[0m");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("\u001B[36mEnter user name: \u001B[0m");
                    String name = scanner.nextLine();
                    System.out.print("\u001B[36mEnter user ID: \u001B[0m");
                    String userId = scanner.nextLine();
                    
                    System.out.print("\u001B[36mIs this user an Employee? (yes/no): \u001B[0m");
                    String userType = scanner.nextLine();
                    
                    if (userType.equalsIgnoreCase("yes")) {
                        System.out.print("\u001B[36mEnter Employee ID: \u001B[0m");
                        String empId = scanner.nextLine();
                        Database.addEmployee(new Employee(name, userId, empId));
                        System.out.println("Employee created successfully!");
                    } else {
                        Database.addUser(new Customer(name, userId));
                        System.out.println("Customer created successfully!");
                    }
                    break;
                
                case 2:
                    System.out.print("\u001B[36mEnter user ID: \u001B[0m");
                    String accUserId = scanner.nextLine();
                    if (!Database.userExists(accUserId)) {
                        System.out.println("Error: User does not exist. Create a user first.");
                        break;
                    }
                    System.out.print("\u001B[36mEnter account number: \u001B[0m");
                    String accNum = scanner.nextLine();
                    System.out.print("\u001B[36mEnter initial balance: \u001B[0m");
                    double balance = scanner.nextDouble();
                    Database.addAccount(new Accounts(accNum, balance, accUserId));
                    System.out.println("Account created successfully!");
                    break;
                
                case 3:
                    System.out.print("\u001B[36mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[36mEnter deposit amount: \u001B[0m");
                    double deposit = scanner.nextDouble();
                    Database.deposit(accNum, deposit);
                    Accounts depAccount = Database.findAccount(accNum);
                    if (depAccount != null) {
                        System.out.println("Current balance: " + depAccount.getBalance());
                    }
                    break;
                
                case 4:
                    System.out.print("\u001B[36mEnter account number: \u001B[0m");
                    accNum = scanner.nextLine();
                    System.out.print("\u001B[36mEnter withdrawal amount: \u001B[0m");
                    double withdraw = scanner.nextDouble();
                    
                    Accounts acc = Database.findAccount(accNum);
                    if (acc != null) {
                        if (acc.getBalance() - withdraw < 500) {
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
                	System.out.println("\u001B[36m1. Create Account\u001B[0m");
                    System.out.println("\u001B[36m2. Close Account\u001B[0m");
                    System.out.println("\u001B[36m3. Exit\u001B[0m");
                    System.out.print("\u001B[36mEnter choice: \u001B[0m");
                    
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    while(a!=8) {
	                    switch(a) {
	                		case 1: 
	                			System.out.print("\u001B[36mEnter user ID: \u001B[0m");
	                            String accUId = scanner.nextLine();
	                            System.out.print("\u001B[36mEnter account number: \u001B[0m");
	                            String accN = scanner.nextLine();
	                            System.out.print("\u001B[36mEnter initial balance: \u001B[0m");
	                            double bal = scanner.nextDouble();
	                            Database.addAccount(new Accounts(accN, bal, accUId));
	                            System.out.println("Account created successfully!");
	                            break;
	                            
	                		case 2: 
	                			 System.out.print("\u001B[36mEnter account number: \u001B[0m");
		                         String accNo = scanner.nextLine();
		                         AccountServices ac=new AccountServices();
		                         ac.closeAccount(accNo);
		                         break;
	                		case 3:  System.out.print("\u001B[36m Thankyou! \u001B[0m");
	                			 a=8;
	                			 break;
	                		default :  System.out.print("\u001B[36m Wrong Input Try Again. \u001B[0m");
	                			 break;
	                			
	                    }
                    }
                    scanner.close();
                    break;
                case 6:
                	System.out.println("\u001B[36m1. Add Employee\u001B[0m");
                    System.out.println("\u001B[36m2. Remove Employee\u001B[0m");
                    System.out.println("\u001B[36m3. Exit\u001B[0m");
                    System.out.print("\u001B[36mEnter choice: \u001B[0m");
                    
                    int b = scanner.nextInt();
                    scanner.nextLine();
                    while(b!=8) {
	                    switch(b) {
	                		case 1: 
	                			System.out.print("\u001B[36mEnter Employee name: \u001B[0m");
	                            String Ename = scanner.nextLine();
	                            System.out.print("\u001B[36mEnter Employee User ID: \u001B[0m");
	                            String EuserId = scanner.nextLine();

	                            
	                            System.out.print("\u001B[36mEnter Employee ID: \u001B[0m");
	                            String empId = scanner.nextLine();
	                            Database.addEmployee(new Employee(Ename, EuserId, empId));
	                            System.out.println("Employee created successfully!");
	                            break;
	                            
	                		case 2: 
	                			 System.out.print("\u001B[36mEnter EmployeeId number: \u001B[0m");
		                         String accNo = scanner.nextLine();
		                         EmployeeServices ac=new EmployeeServices();
		                         ac.removeEmployee(accNo);
		                         break;
	                		case 3:  System.out.print("\u001B[36m Thankyou! \u001B[0m");
	                			 b=8;
	                			 break;
	                		default :  System.out.print("\u001B[36m Wrong Input Try Again. \u001B[0m");
	                			 break;
	                			
	                    }
                    }
                    scanner.close();
                    break;
                case 7:
                	System.out.println("\u001B[36m1. Add Customer\u001B[0m");
                    System.out.println("\u001B[36m2. Remove Customer\u001B[0m");
                    System.out.println("\u001B[36m3. Exit\u001B[0m");
                    System.out.print("\u001B[36mEnter choice: \u001B[0m");
                    
                    int c = scanner.nextInt();
                    scanner.nextLine();
                    while(c!=8) {
	                    switch(c) {
	                		case 1: 
	                			System.out.print("\u001B[36mEnter user name: \u001B[0m");
	                            String Cname = scanner.nextLine();
	                            System.out.print("\u001B[36mEnter user ID: \u001B[0m");
	                            String CuserId = scanner.nextLine();
	                            Database.addUser(new Customer(Cname, CuserId));
	                            System.out.println("Customer created successfully!");
	                            break;
	                		case 2: 
	                			 System.out.print("\u001B[36mEnter CustomerId number: \u001B[0m");
		                         String accNo = scanner.nextLine();
		                         CustomerServices ac=new CustomerServices();
		                         ac.removeCustomer(accNo);
		                         break;
	                		case 3:  System.out.print("\u001B[36m Thankyou! \u001B[0m");
	                				c=8;
	                			 break;
	                		default :  System.out.print("\u001B[36m Wrong Input Try Again. \u001B[0m");
	                			 break;
	                			
	                    }
                    }
                    scanner.close();
                    break;
                case 8:
                	l=-1;
                	break;
                
                default:
                    System.out.println("\u001B[36mInvalid choice, please try again.\u001B[0m");
            }
        }
    }
}
