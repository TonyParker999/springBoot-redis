package com.springbootredis.redis.service;


import com.springbootredis.redis.dao.TestDao;
import com.springbootredis.redis.model.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl  {
    @Resource
    private TestDao testDao;


    public List<Map<String,Object>> getUsers(Map<String, Object> map) {
        return testDao.getUsers(map);
    }

//    @Transactional
    public void update(Map<String, Object> map) {
        testDao.updateSpecialReview(map);
        System.out.println(1/0);
    }

    @Transactional
    @CachePut(key="#user.id",value = "User")
    public int insertUser(User user) {
        testDao.insertUser(user);
        return user.getId();
    }

    @Cacheable(key="#id",value ="user")
    public User getUserById(int id){
        User user = testDao.getUserById(id);
        return user;
    }
}
