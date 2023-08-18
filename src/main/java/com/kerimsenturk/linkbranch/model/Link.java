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

    public Link(int id, String url, byte[] icon, LinkCategory category, User user) {
        this.id = id;
        this.url = url;
        this.icon = icon;
        this.category = category;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public LinkCategory getCategory() {
        return category;
    }

    public void setCategory(LinkCategory category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
