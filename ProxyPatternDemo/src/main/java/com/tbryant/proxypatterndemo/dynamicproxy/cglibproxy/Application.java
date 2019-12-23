package com.tbryant.proxypatterndemo.dynamicproxy.cglibproxy;

import com.tbryant.proxypatterndemo.User;
import net.sf.cglib.proxy.Enhancer;

public class Application {
    public static void main(String[] args) {
        User user = new User("tbryant", 18);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
//        enhancer.setInterfaces(new Class<?>[] {EnhancedConfiguration.class});
//        enhancer.setUseFactory(false);
//        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//        enhancer.setStrategy(new BeanFactoryAwareGeneratorStrategy(classLoader));
//        enhancer.setCallbackFilter(CALLBACK_FILTER);
//        enhancer.setCallbackTypes(CALLBACK_FILTER.getCallbackTypes());
        enhancer.setCallback(new UserServiceMethodInterceptor());
        enhancer.setCallbackType(UserServiceMethodInterceptor.class);
        UserService proxy = (UserService) enhancer.create();
        proxy.insertUser(user);
    }
}
