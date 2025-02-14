package com.Banking.Services;

import com.Banking.Database.Database;
import com.Banking.Models.Employee;

public class EmployeeServices {
	private Database db=new Database();

    public void addEmployee(Employee employee) {
        	db.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }


    public void removeEmployee(String employeeId) {
        db.delEmployee(employeeId);
        }
    
}
