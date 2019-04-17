package com.huawei.demo.dao;

import com.huawei.demo.entity.User;


public interface IUserDao {

    /**
     * 通过name查询User
     * @param name
     * @return User
     */
    User getUserByName(String name);

    /**
     * 插入一条数据，包括name和age
     * @param name
     * @param age
     */
    void insertUser(String name, Integer age);
}
