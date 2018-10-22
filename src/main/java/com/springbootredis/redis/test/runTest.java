package com.springbootredis.redis.test;

import com.springbootredis.redis.utils.ProxyUtils;

public class runTest {
    public static void main(String[] args) {
        LisonCompany company=new LisonCompany();
        Person student=new Student("张三");
        company.setFactory(student);
        Person person = (Person)company.getProxyInstance();
        student.giveMoney();

        ProxyUtils.generateClassFile(student.getClass(),person.getClass().getSimpleName());

    }
}
