package com.springbootredis.redis.test;

public class Demo {
    public static void main(String[] args) {
        Demo d1=new Demo();
        Demo d2=new Demo();
        System.out.println(d1==(d1=d2));
        System.out.println(System.getProperties());
    }
}
