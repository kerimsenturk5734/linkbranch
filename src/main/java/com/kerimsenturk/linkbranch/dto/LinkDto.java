package com.kerimsenturk.linkbranch.dto;

import com.kerimsenturk.linkbranch.model.enums.LinkCategory;

public class LinkDto {
    private int id;
    private String url;
    private byte[] icon;
    private LinkCategory category;
    private UserDto user;

    public LinkDto() {
    }

    public LinkDto(int id, String url, byte[] icon, LinkCategory category, UserDto user) {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
