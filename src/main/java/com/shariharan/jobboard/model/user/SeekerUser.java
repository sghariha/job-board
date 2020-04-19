package com.shariharan.jobboard.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SeekerUsers")
public class SeekerUser extends User {
    private String dob;

    public SeekerUser(String email, String password, String firstName, String lastName, String dob) {
        super(email, password, firstName, lastName);
        this.dob = dob;
    }
}