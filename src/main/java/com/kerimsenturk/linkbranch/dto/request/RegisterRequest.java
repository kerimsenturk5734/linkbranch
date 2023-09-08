package com.kerimsenturk.linkbranch.dto.request;

import com.kerimsenturk.linkbranch.model.enums.UserType;

public class RegisterRequest {
    private String name;
    private String lastname;
    private String username;
    private String mail;
    private UserType userType;
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String name, String lastname, String username, String mail, UserType userType, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.userType = userType;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
