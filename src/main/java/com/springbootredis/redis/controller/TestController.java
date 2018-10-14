package com.springbootredis.redis.controller;

import com.springbootredis.redis.model.User;
import com.springbootredis.redis.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    TestServiceImpl testService;

    @RequestMapping("/test")
    public Map<String,Object> Test(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("url",url);
        return map;
    }

    @RequestMapping("/get")
    public Map<String,Object> get(){
        List<Map<String,Object>> users = testService.getUsers(new HashMap<>());
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("users",users);
        return dataMap;
    }

    @RequestMapping("/getUserById")
    public User getUserById(){

//        User user = testService.getUserById(new User(3));
        User user = testService.getUserById(3);
//        Integer userById = testService.getUserById(new User(2));
        return user;
    }

    @RequestMapping("/insertUser")
    public User insertUser() {
        User user = new User();
        user.setId(3);
        user.setName("Tom");
        user.setPhone("15868156227");
        int id = testService.insertUser(user);
        return user;
    }

}
