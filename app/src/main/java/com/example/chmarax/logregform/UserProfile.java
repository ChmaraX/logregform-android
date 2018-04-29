package com.example.chmarax.logregform;

/**
 * Created by Adam on 28.04.2018.
 */

public class UserProfile {

    private String username;
    private String password;

    public UserProfile() {
        //firebase constructor
    }


    public UserProfile(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
