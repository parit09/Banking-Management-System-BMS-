package com.Banking.Models;

public class Customer extends User {
    public Customer(String name, String userId) {
        super(name, userId);
    }
    public String getCustomerId() {
        return userId;
    }
}
