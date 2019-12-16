package com.tbryant.proxypatterndemo.dynamicproxy.jdkproxy;

import com.tbryant.proxypatterndemo.User;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) throws Throwable {
        User user = new User("tbryant", 18);
        // JDK动态代理
        IUserService jdkProxy = (IUserService) Proxy.newProxyInstance(Application.class.getClassLoader(),
                new Class[]{IUserService.class}, new IUserServiceInvocationHandler(new UserService()));
        jdkProxy.insertUser(user);
    }
}
