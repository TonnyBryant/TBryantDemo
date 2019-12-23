package com.tbryant.proxypatterndemo.dynamicproxy.cglibproxy;

import com.tbryant.proxypatterndemo.User;

public class UserService {
    public int insertUser(User user) {
        System.out.println("假装访问数据库，插入一条User数据");
        return 1;
    }
}
