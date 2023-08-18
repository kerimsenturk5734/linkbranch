package com.kerimsenturk.linkbranch.model.dto;

import com.kerimsenturk.linkbranch.model.enums.UserType;

public class UserDto {

    private int uuid;
    private String name;
    private String lastname;
    private String username;
    private String mail;
    private UserType userType;
    private List<LinkDto> links;
    private ProfileDto profile;

    public UserDto() {
    }

    public UserDto(int uuid, String name, String lastname, String username, String mail, UserType userType, List<LinkDto> links, ProfileDto profile) {
        this.uuid = uuid;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.userType = userType;
        this.links = links;
        this.profile = profile;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
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

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }

    public ProfileDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }
}
