package com.tbryant.proxypatterndemo.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CGLib动态代理：调用UserServiceMethodInterceptor.intercept方法");
        return proxy.invokeSuper(obj, args);
    }
}
