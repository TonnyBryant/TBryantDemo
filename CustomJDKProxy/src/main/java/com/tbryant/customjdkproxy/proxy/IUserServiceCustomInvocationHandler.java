package com.tbryant.customjdkproxy.proxy;

import com.tbryant.customjdkproxy.customproxy.CustomInvocationHandler;

import java.lang.reflect.Method;

public class IUserServiceCustomInvocationHandler implements CustomInvocationHandler {
    private Object target;

    public IUserServiceCustomInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自定义动态代理：调用IUserServiceCustomInvocationHandler.invoke方法");
        return method.invoke(target, args);
    }
}
