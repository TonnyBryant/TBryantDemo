package com.tbryant.proxypatterndemo.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IUserServiceInvocationHandler implements InvocationHandler {
    private Object target;

    public IUserServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理：调用IUserServiceInvocationHandler.invoke方法");
        return method.invoke(target, args);
    }
}
