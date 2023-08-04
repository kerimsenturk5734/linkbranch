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
}
