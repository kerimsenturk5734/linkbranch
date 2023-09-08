package com.kerimsenturk.linkbranch.dto.response;

import com.kerimsenturk.linkbranch.dto.UserDto;

import java.util.Date;

public class RegisterResponse {
    private UserDto userDto;
    private Date createdAt;

    public RegisterResponse(){
    }

    public RegisterResponse(UserDto userDto, Date createdAt){
        this.userDto = userDto;
        this.createdAt = createdAt;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
