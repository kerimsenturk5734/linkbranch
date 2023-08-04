package com.kerimsenturk.linkbranch.controller;


import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.model.enums.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/test")
public class TestController {
    @GetMapping("/{id}")
    public User testEndpoint(int id){
        return new User(id,
                "Kerim",
                "Senturk",
                "zoww",
                "12345678",
                "abc@gmail.com",
                UserType.ADMIN);
    }
}
