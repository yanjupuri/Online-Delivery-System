package com.company;

import java.util.Date;

public abstract class WebUser {
    private final String userId;
    private final String password;
    private final Date registerDate;

    public WebUser(String userId, String password, Date registerDate){
        this.registerDate = registerDate;
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public String getUserId() {
        return userId;
    }
}
