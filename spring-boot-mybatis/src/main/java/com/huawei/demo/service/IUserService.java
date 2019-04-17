package com.huawei.demo.service;

import com.huawei.demo.entity.User;

public interface IUserService {

    User getUserByName(String name);

    void insertUserInfo(String name, Integer age);
}
