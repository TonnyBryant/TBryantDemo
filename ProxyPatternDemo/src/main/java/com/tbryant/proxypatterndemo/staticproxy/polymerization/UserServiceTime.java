package com.tbryant.proxypatterndemo.staticproxy.polymerization;

import com.tbryant.proxypatterndemo.User;

public class UserServiceTime implements IUserService {
    IUserService target;

    public UserServiceTime(IUserService target) {
        target = target;
    }

    @Override
    public int insertUser(User user) {
        System.out.println("=====记录执行时间=====");
        return target.insertUser(user);
    }
}
