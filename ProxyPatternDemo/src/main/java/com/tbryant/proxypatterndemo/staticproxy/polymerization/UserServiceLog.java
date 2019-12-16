package com.tbryant.proxypatterndemo.staticproxy.polymerization;

import com.tbryant.proxypatterndemo.User;

public class UserServiceLog implements IUserService {
    IUserService target;

    public UserServiceLog(IUserService target) {
        target = target;
    }

    @Override
    public int insertUser(User user) {
        System.out.println("=====记录执行日志=====");
        return target.insertUser(user);
    }
}
