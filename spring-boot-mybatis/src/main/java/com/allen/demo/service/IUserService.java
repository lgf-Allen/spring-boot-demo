package com.allen.demo.service;

import com.allen.demo.entity.User;

public interface IUserService {

    User getUserByName(String name);

    void insertUserInfo(String name, Integer age);
}
