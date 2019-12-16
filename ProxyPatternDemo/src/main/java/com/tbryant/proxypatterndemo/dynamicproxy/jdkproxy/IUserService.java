package com.tbryant.proxypatterndemo.dynamicproxy.jdkproxy;

import com.tbryant.proxypatterndemo.User;

public interface IUserService {
    public int insertUser(User user) throws Throwable;
}
