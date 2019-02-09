package com.springbootredis.redis.service;

import com.springbootredis.redis.model.User;

import java.util.List;
import java.util.Map;

public interface TestService {
    int insertUser(User user);

    List<Map<String,Object>> getUsers(Map<String, Object> map);

    void update(Map<String, Object> map);

    User getUserById(int id);

    void shopping(User u);
}
