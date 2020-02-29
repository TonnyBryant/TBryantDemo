package com.tbryant.springmvctest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }
}
