package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.converter.UserAndUserDtoConverter;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.dto.response.LoginResponse;
import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.repository.UserRepository;
import com.kerimsenturk.linkbranch.util.Result.DataResult;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.HttpResult;
import com.kerimsenturk.linkbranch.util.Result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserAndUserDtoConverter userAndUserDtoConverter;
    public UserService(UserRepository userRepository, UserAndUserDtoConverter userAndUserDtoConverter) {
        this.userRepository = userRepository;
        this.userAndUserDtoConverter = userAndUserDtoConverter;
    }

    @Override
    public HttpDataResult<UserDto> getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        //validate user
        if(user == null)
            return new HttpDataResult<UserDto>(null, false, "User Not Found", HttpStatus.NOT_FOUND);

        //convert user to UserDto
        UserDto userDto = userAndUserDtoConverter.convert(user);

        return new HttpDataResult<>(userDto, true, HttpStatus.OK);
    }
}
