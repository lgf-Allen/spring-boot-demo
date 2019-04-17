package com.allen.demo.controller;

import com.allen.demo.entity.User;
import com.allen.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping
    public User getUserByName(@RequestParam("name")String name){
        LOGGER.info("Search user by name: {}", name);
        User user = userService.getUserByName(name);
        LOGGER.info("Found user is {}",user.toString());
        return user;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.insertUserInfo(user.getName(), user.getAge());
        LOGGER.info("create user is {}", user.toString());
    }

}
