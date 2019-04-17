package com.allen.demo.dao;

import com.allen.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements IUserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void insertUser(String name, Integer age) {
        userMapper.insert(name, age);
    }
}
