package com.kerimsenturk.linkbranch.controller;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
import com.kerimsenturk.linkbranch.dto.request.RegisterRequest;
import com.kerimsenturk.linkbranch.dto.response.LoginResponse;
import com.kerimsenturk.linkbranch.dto.response.RegisterResponse;
import com.kerimsenturk.linkbranch.service.IUserService;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/uuid/")
    public ResponseEntity<?> getUserByUuid(@RequestParam int uuid){
        HttpDataResult<UserDto> httpDataResult = userService.getUserByUuid(uuid);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }
    @GetMapping("/username/")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username){
        HttpDataResult<UserDto> httpDataResult = userService.getUserByUsername(username);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

    @PostMapping("/login/")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        HttpDataResult<LoginResponse> httpDataResult = userService.login(loginRequest);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

    @PostMapping("/register/")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        HttpDataResult<RegisterResponse> httpDataResult = userService.register(registerRequest);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

}