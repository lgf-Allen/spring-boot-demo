package com.allen.demo.dao;

import com.allen.demo.entity.User;


public interface IUserDao {

    /**
     * 通过name查询User
     *
     * @param name
     * @return User
     */
    User getUserByName(String name);

    /**
     * 插入一条数据，包括name和age
     *
     * @param name
     * @param age
     */
    void insertUser(String name, Integer age);

    /**
     * 根据id更新User
     *
     * @param user
     */
    void updatUser(User user);

    /**
     * 根据id删除User
     *
     * @param id
     */
    void deleteUserById(Long id);
}
