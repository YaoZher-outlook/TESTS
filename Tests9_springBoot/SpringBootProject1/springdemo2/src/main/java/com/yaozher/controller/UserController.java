package com.yaozher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.yaozher.pojo.User;
import com.yaozher.service.UserService;

//用户信息管理
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> list() {
        return userService.listUsers();
    }
}
