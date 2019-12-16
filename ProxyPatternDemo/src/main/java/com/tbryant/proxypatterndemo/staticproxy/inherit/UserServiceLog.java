package com.tbryant.proxypatterndemo.staticproxy.inherit;

import com.tbryant.proxypatterndemo.User;

public class UserServiceLog extends UserService {
    @Override
    public int insertUser(User user) {
        System.out.println("=====记录执行日志=====");
        return super.insertUser(user);
    }
}
