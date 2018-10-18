package com.springbootredis.redis.dao;

import com.springbootredis.redis.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserDao {
    @Select("select * from sys_user u where u.id=#{id}")
    User getUserById(int id);

    @Select("select * from sys_user u where u.name=#{userName}")
    User getUserByUserName(@Param("userName") String userName);
}
