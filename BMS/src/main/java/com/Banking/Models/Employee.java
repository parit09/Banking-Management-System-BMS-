package com.Banking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee extends User{
	@Id
	private String employeeId;

    public Employee(String name, String userId, String employeeId) {
        super(name, userId);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
