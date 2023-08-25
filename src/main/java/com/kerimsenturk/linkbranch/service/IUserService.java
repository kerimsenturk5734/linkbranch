package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.dto.response.LoginResponse;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;

public interface IUserService {
    HttpDataResult<UserDto> getUserByUsername(String username);
    HttpDataResult<UserDto> getUserByUuid(int uuid);
    HttpDataResult<LoginResponse> login(LoginRequest loginRequest);
}
