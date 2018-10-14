package com.springbootredis.redis.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String phone;

    public User(int id) {
        this.id = id;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}