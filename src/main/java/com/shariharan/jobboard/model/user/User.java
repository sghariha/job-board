package com.shariharan.jobboard.model.user;

import org.springframework.data.annotation.Id;

public abstract class User {
    @Id
    protected String id;
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;

    User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
    	return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setId(String id) {
    	this.id = id;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}