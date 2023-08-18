package com.kerimsenturk.linkbranch.model;

import com.kerimsenturk.linkbranch.model.enums.ProfileTheme;
import jakarta.persistence.*;

@Table(name = "profile")
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "profile_image")
    private byte[] profileImage;
    @Enumerated(EnumType.STRING)
    @Column(name = "theme")
    private ProfileTheme theme;

    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile() {
    }

    public Profile(int id, String description, byte[] profileImage, ProfileTheme theme, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
