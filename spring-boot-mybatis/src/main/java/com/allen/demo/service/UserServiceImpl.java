package com.allen.demo.service;

import com.allen.demo.dao.IUserDao;
import com.allen.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    public void insertUserInfo(String name, Integer age){
        userDao.insertUser(name, age);
    }
}
