package com.springbootredis.redis.service;

import com.springbootredis.redis.model.User;

public interface UserService {
    User getUserByName(String userName);

    void updateUser(User user);
}
