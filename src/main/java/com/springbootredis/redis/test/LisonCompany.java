package com.springbootredis.redis.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LisonCompany implements InvocationHandler {

    private Object factory;//被代理的对象

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    //通过Proxy获取动态代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //dosomeThingBefore...
        Object ret=method.invoke(factory,args);
        //dosomeThingEnd....
        return ret;
    }
}
