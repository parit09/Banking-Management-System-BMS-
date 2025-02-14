package com.Banking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class User {
	
    protected String name;
    @Id
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}
