package com.Banking.Services;

import com.Banking.Database.Database;
import com.Banking.Models.Customer;

public class CustomerServices {

	private Database db =new Database();
    public void addCustomer(Customer customer) {
        db.addCustomer(customer);
    }

    public void removeCustomer(String userId) {
        db.delCustomer(userId);
    }

}
