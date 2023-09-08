package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.dto.request.RegisterRequest;
import com.kerimsenturk.linkbranch.dto.response.LoginResponse;
import com.kerimsenturk.linkbranch.dto.response.RegisterResponse;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;

public interface IUserService {
    HttpDataResult<UserDto> getUserByUsername(String username);
    HttpDataResult<UserDto> getUserByUuid(int uuid);
    HttpDataResult<LoginResponse> login(LoginRequest loginRequest);

    //To Register that user which will be had none-admin user type
    HttpDataResult<RegisterResponse> register(RegisterRequest registerRequest);

    //To Register that user which will be had admin user type
    HttpDataResult<RegisterResponse> registerAdmin(RegisterRequest registerRequest);
}
