package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.converter.UserAndUserDtoConverter;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.dto.response.LoginResponse;
import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.repository.UserRepository;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
            return new HttpDataResult<UserDto>(
                    null,
                    false,
                    String.format("User Not Found with username = %s", username),
                    HttpStatus.NOT_FOUND);

        //convert user to UserDto
        UserDto userDto = userAndUserDtoConverter.convert(user);

        return new HttpDataResult<>(userDto, true, HttpStatus.OK);
    }

    @Override
    public HttpDataResult<UserDto> getUserByUuid(int uuid) {
        User user = userRepository.getUserByUuid(uuid);
        //validate user
        if(user == null)
            return new HttpDataResult<UserDto>(
                    null,
                    false,
                    String.format("User Not Found with uuid = %d", uuid),
                    HttpStatus.NOT_FOUND);

        //convert user to UserDto
        UserDto userDto = userAndUserDtoConverter.convert(user);

        return new HttpDataResult<>(userDto, true, HttpStatus.OK);
    }

    @Override
    public HttpDataResult<LoginResponse> login(LoginRequest loginRequest) {
        User user = userRepository.getUserByUsername(loginRequest.getUsername());
        //validate user
        if(user == null)
            return new HttpDataResult<LoginResponse>(
                    null,
                    false,
                    String.format("User Not Found with username = %s", loginRequest.getUsername()),
                    HttpStatus.NOT_FOUND);

        else{
            if(Objects.equals(loginRequest.getPassword(), user.getPassword())){
                //fill the loginResponse
                LoginResponse loginResponse = new LoginResponse();

                return new HttpDataResult<LoginResponse>(
                        loginResponse,
                        true,
                        String.format(
                                "Successfully logged with username = %s, password = %s",
                                loginRequest.getUsername(),
                                user.getPassword()),
                        HttpStatus.OK);
            }
            else{
                return new HttpDataResult<LoginResponse>(
                        null,
                        false,
                        String.format("Your password is incorrect password = %s", loginRequest.getPassword()),
                        HttpStatus.UNAUTHORIZED);
            }
        }
    }
}
