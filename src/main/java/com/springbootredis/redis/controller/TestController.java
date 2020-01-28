package com.springbootredis.redis.controller;

import com.springbootredis.redis.model.User;
import com.springbootredis.redis.service.TestServiceImpl;
import com.springbootredis.redis.utils.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public Map<String,Object> Test(HttpServletRequest request){

        Map<String,Object> map=new HashMap<String,Object>();
        request.getSession().setAttribute("userName","Tony parker");
        map.put("sessionId", request.getSession().getId());
        map.put("url",url);
        return map;
    }

    @RequestMapping("/getSession")
    public Map<String,Object> getSession(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        String userName = (String)request.getSession().getAttribute("userName");
        map.put("userName",userName);
        return map;
    }

    @RequestMapping("/getUserList")
    public Map<String,Object> get(){
        List<Map<String,Object>> users = testService.getUsers(new HashMap<>());
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("users",users);
        dataMap.put("aaa","121");
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
