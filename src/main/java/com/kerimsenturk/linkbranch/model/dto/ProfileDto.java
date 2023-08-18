package com.kerimsenturk.linkbranch.model.dto;

import com.kerimsenturk.linkbranch.model.enums.ProfileTheme;

public class ProfileDto {
    private int id;
    private String description;
    private byte[] profileImage;
    private ProfileTheme theme;
    private UserDto user;

    public ProfileDto() {
    }

    public ProfileDto(int id, String description, byte[] profileImage, ProfileTheme theme, UserDto user) {
        this.id = id;
        this.description = description;
        this.profileImage = profileImage;
        this.theme = theme;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public ProfileTheme getTheme() {
        return theme;
    }

    public void setTheme(ProfileTheme theme) {
        this.theme = theme;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
