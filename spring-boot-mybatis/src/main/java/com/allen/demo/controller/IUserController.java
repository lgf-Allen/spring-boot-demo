package com.allen.demo.controller;

import com.allen.demo.entity.User;

public interface IUserController {

    User getUserByName(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

}


