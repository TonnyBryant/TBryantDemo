package com.tbryant.springmvctest.customspringmvc.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// 参考spring的WebApplicationInitializer接口
public interface CustomWebApplicationInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}
