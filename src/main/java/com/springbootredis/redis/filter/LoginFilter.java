package com.springbootredis.redis.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*" , filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String userName = req.getParameter("userName");
        if("".equals(userName)){
//            ....
        }else {

        }
        System.out.println("do LoginFilter.........");
        filterChain.doFilter(req,response);//放行
    }

    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter.....");
    }
}
