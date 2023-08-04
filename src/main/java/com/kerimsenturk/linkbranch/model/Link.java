package com.kerimsenturk.linkbranch.model;

import com.kerimsenturk.linkbranch.model.enums.LinkCategory;
import jakarta.persistence.*;

@Table(name = "links")
@Entity
public class Link {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "url")
    private String url;
    @Column(name = "icon")
    private byte[] icon;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private LinkCategory category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Link() {
    }

    public Link(int id, String url, byte[] icon, LinkCategory category) {
        this.id = id;
        this.url = url;
        this.icon = icon;
        this.category = category;
    }
}
