package com.tbryant.proxypatterndemo.staticproxy.inherit;

import com.tbryant.proxypatterndemo.User;

public class UserServiceTime extends UserService {
    @Override
    public int insertUser(User user) {
        System.out.println("=====记录执行时间=====");
        return super.insertUser(user);
    }
}
