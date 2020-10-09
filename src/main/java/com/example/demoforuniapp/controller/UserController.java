package com.example.demoforuniapp.controller;

import com.example.demoforuniapp.entity.User;
import com.example.demoforuniapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public String getUser(String username){
        User user = userService.findOne(username);
        return user.getPassword();
    }
}
