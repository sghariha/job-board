package com.shariharan.jobboard.auth;

public class TokenPayload {
    private String email;
    private String id;
    private String userType;

    public TokenPayload(String email, String id, String userType) {
        this.email = email;
        this.id = id;
        this.userType = userType;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}