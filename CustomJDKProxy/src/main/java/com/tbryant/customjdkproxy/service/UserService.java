package com.tbryant.customjdkproxy.service;

import com.tbryant.customjdkproxy.User;

public class UserService implements IUserService {
    @Override
    public int insertUser(User user) {
        System.out.println("假装访问数据库，插入一条User数据");
        return 1;
    }
}
