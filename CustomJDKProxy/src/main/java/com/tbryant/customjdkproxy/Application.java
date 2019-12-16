package com.tbryant.customjdkproxy;

import com.tbryant.customjdkproxy.customproxy.CustomProxy;
import com.tbryant.customjdkproxy.proxy.IUserServiceCustomInvocationHandler;
import com.tbryant.customjdkproxy.proxy.IUserServiceInvocationHandler;
import com.tbryant.customjdkproxy.service.IUserService;
import com.tbryant.customjdkproxy.service.UserService;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) throws Throwable {
        User user = new User("tbryant", 18);
        // JDK动态代理
        System.out.println("JDK动态代理demo：");
        IUserService jdkProxy = (IUserService) Proxy.newProxyInstance(Application.class.getClassLoader(),
                new Class[]{IUserService.class}, new IUserServiceInvocationHandler(new UserService()));
        jdkProxy.insertUser(user);

        // 自定义动态代理
        System.out.println("自定义动态代理demo：");
        IUserService customProxy = (IUserService) CustomProxy.newProxyInstance(Application.class.getClassLoader(),
                new Class[]{IUserService.class}, new IUserServiceCustomInvocationHandler(new UserService()));
        customProxy.insertUser(user);
    }
}
