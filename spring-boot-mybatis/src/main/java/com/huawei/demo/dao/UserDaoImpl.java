package com.huawei.demo.dao;

import com.huawei.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {

    @Autowired
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
