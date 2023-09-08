package com.kerimsenturk.linkbranch.model.builder;

import com.kerimsenturk.linkbranch.model.Profile;
import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.model.enums.ProfileTheme;

public class ProfileBuilder {
    private int id;
    private String description;
    private byte[] profileImage;
    private ProfileTheme theme;
    private User user;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public ProfileTheme getTheme() {
        return theme;
    }

    public User getUser() {
        return user;
    }

    public ProfileBuilder id(int id) {
        this.id = id;
        return this;
    }

    public ProfileBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProfileBuilder profileImage(byte[] profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public ProfileBuilder theme(ProfileTheme theme) {
        this.theme = theme;
        return this;
    }

    public ProfileBuilder user(User user) {
        this.user = user;
        return this;
    }

    public Profile build(){
        return new Profile(this);
    }

    public Profile build(ProfileConfig config){
        return new Profile(config.getProfileBuilder());
    }
}
