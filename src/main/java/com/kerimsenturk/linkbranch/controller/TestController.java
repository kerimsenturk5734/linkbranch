package com.kerimsenturk.linkbranch.controller;


import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.model.dto.converter.UserAndUserDtoConverter;
import com.kerimsenturk.linkbranch.model.enums.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/test")
public class TestController {
    private final UserAndUserDtoConverter userAndUserDtoConverter;

    public TestController(UserAndUserDtoConverter userAndUserDtoConverter) {
        this.userAndUserDtoConverter = userAndUserDtoConverter;
    }

    @GetMapping("/{id}")
    public User testEndpoint(int id){
        userAndUserDtoConverter.convert(new User());
        return new User(id,
                "Kerim",
                "Senturk",
                "zoww",
                "12345678",
                "abc@gmail.com",
                UserType.ADMIN);
    }
}
