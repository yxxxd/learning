package com.yxd.hi.controller;

import com.yxd.hi.entity.User;
import com.yxd.hi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuxudong
 * @date 2019/9/25 16:45
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registry")
    public User createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.create(username,password);
    }

    @PostMapping("/login")
    public User login(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        return userService.authentication(username, password);
    }
}
