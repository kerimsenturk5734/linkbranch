package com.kerimsenturk.linkbranch.controller;

import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.request.LoginRequest;
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

    @GetMapping("/getUserByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username){
        HttpDataResult<UserDto> httpDataResult = userService.getUserByUsername(username);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

}