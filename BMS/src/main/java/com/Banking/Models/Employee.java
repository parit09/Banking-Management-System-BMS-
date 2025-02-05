package com.Banking.Models;

public class Employee extends User{
	private String employeeId;

    public Employee(String name, String userId, String employeeId) {
        super(name, userId);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
