package com.allen.demo.dao;

import com.allen.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER_TAB WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER_TAB(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE USER_TAB SET NAME = #{name} ,AGE = #{age} WHERE ID = #{id}")
    int updateUserById(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM USER_TAB WHERE ID = #{id}")
    int deleteUserById(@Param("id") Long id);
}
