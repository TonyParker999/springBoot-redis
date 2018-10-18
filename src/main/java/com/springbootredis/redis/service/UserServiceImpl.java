package com.springbootredis.redis.service;

import com.springbootredis.redis.dao.UserDao;
import com.springbootredis.redis.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl {
    @Resource
    private UserDao userDao;

    public User getUserByName(String userName) {
        User user = userDao.getUserByUserName(userName);
        return user;
    }
}
