package com.tbryant.springmvctest.demo.controller;

import com.tbryant.springmvctest.demo.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/getuser")
    @ResponseBody
    public UserEntity getUser() {
        return new UserEntity("TBryant", "18");
    }
}
