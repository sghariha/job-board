package com.shariharan.jobboard.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PosterUsers")
public class PosterUser extends User {
    private String companyId;

    public PosterUser(String email, String password, String firstName, String lastName, String companyId) {
        super(email, password, firstName, lastName);
        this.companyId = companyId;
    }
}