package com.allen.demo.controller;

import com.allen.demo.entity.User;
import com.allen.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl implements IUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private IUserService userService;

    @GetMapping
    @Override
    public User getUserByName(@RequestParam("name")String name){
        LOGGER.info("Search user by name: {}", name);
        User user = userService.getUserByName(name);
        LOGGER.info("Found user is {}",user.toString());
        return user;
    }

    @PostMapping
    @Override
    public void createUser(@RequestBody User user){
        userService.insertUserInfo(user.getName(), user.getAge());
        LOGGER.info("create user is {}", user.toString());
    }

    @PutMapping
    @Override
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping
    @Override
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

}
