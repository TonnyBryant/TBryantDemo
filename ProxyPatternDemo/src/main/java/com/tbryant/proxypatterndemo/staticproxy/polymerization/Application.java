package com.tbryant.proxypatterndemo.staticproxy.polymerization;

import com.tbryant.proxypatterndemo.User;

public class Application {
    public static void main(String[] args) {
        User user = new User("tbryant", 18);
        System.out.println("demo1：原逻辑");
        IUserService target = new UserService();
        target.insertUser(user);
        System.out.println("demo2：记录执行时间");
        IUserService proxyTime = new UserServiceTime(target);
        proxyTime.insertUser(user);
        System.out.println("demo3：记录执行日志");
        IUserService proxyLog = new UserServiceLog(target);
        proxyLog.insertUser(user);
        System.out.println("demo4：先记录执行日志，再记录执行时间");
        IUserService proxyLogTime = new UserServiceLog(proxyTime);
        proxyLogTime.insertUser(user);
        System.out.println("demo5：先记录执行时间，再记录执行日志");
        IUserService proxyTimeLog = new UserServiceTime(proxyLog);
        proxyTimeLog.insertUser(user);
    }
}
