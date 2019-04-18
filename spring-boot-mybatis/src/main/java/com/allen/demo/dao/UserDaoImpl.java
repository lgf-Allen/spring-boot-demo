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
        int res = userMapper.insert(name, age);
    }

    @Override
    public void updatUser(User user) {
        int res = userMapper.updateUserById(user.getId(), user.getName(), user.getAge());
    }

    @Override
    public void deleteUserById(Long id) {
        int res = userMapper.deleteUserById(id);
    }
}
