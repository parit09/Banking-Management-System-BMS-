package com.Banking.Services;

import com.Banking.Database.Database;
import com.Banking.Models.Accounts;
public class AccountServices {
    private Database db=new Database();

    public void createAccount(Accounts account) {
        db.addAccount(account);
        System.out.println("Account created: " + account.getAccountNumber());
    }

    public void closeAccount(String accountNumber) {
        db.delAccount(accountNumber);
    }
}