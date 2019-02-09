package com.springbootredis.redis.controller;

import com.springbootredis.redis.model.User;
import com.springbootredis.redis.service.TestServiceImpl;
import com.springbootredis.redis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getServiceMsg")
    @ResponseBody
    public Map<String,Object> getServiceMsg(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<>();
        String localAddr = request.getLocalAddr();//取得服务器IP
        int localPort = request.getLocalPort();//取得服务器端口

        map.put("local",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());

        map.put("localAddr",localAddr);
        map.put("localPort",localPort);
        return map;
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request,HttpServletResponse response){
        List l=new ArrayList<>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.getUserByName(userName);
        if(null!=user){
            if(password.equals(user.getPassword())){
                request.getSession().setAttribute("userName",userName);
                try {
                    response.sendRedirect(request.getContextPath()+"/index.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    response.sendRedirect(request.getContextPath()+"/login.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                response.sendRedirect(request.getContextPath()+"/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
