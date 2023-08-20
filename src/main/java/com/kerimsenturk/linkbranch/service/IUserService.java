package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.Result;

public interface IUserService {
    HttpDataResult<UserDto> getUserByUsername(String username);
}
