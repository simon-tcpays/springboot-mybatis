package com.example.demoforuniapp.controller;

import com.example.demoforuniapp.entity.User;
import com.example.demoforuniapp.service.UserService;
import com.example.demoforuniapp.vos.LoginReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: simon
 * @Date: 2020/10/13 12:59
 */
@RestController
@RequestMapping("/")
@Slf4j
public class UserController{

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginReq loginReq){
        log.info("{},{}",loginReq.username,loginReq.password);
        User user = userService.findOne(loginReq.username);
        if(user !=null && user.getPassword().equals(loginReq.password)){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/get")
    public String getUser(String username){
        User user = userService.findOne(username);
        return user.getPassword();
    }
}
