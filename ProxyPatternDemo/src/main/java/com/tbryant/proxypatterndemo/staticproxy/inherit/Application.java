package com.tbryant.proxypatterndemo.staticproxy.inherit;

import com.tbryant.proxypatterndemo.User;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceTimeLog();
        User user = new User("tbryant", 18);
        userService.insertUser(user);
    }
}
