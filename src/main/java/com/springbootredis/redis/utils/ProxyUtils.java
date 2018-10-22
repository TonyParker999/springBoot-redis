package com.springbootredis.redis.utils;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyUtils {
    public static void generateClassFile(Class clazz,String proxyName){
        //根据类信息和提供的代理类名称，生成字节码
//        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});
        byte[] classFile = ProxyGenerator.generateProxyClass( proxyName, clazz.getInterfaces());
        String paths=clazz.getResource(".").getPath();
//        String paths="F:\\java/";
        System.out.println(paths);
        FileOutputStream out =null;
        try {
            out=new FileOutputStream(paths + proxyName + ".class" );
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
