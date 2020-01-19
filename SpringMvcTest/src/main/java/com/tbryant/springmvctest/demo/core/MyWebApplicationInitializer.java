package com.tbryant.springmvctest.demo.core;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

// 该类从官方文档拷贝，主要目的初始化spring容器，注册servlet和注册servlet-mapping
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    // ServletContext代替web.xml
    @Override
    public void onStartup(ServletContext servletCxt) {
        // 实例化spring容器
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
//		ac.refresh();
        // DispatcherServlet装载到web容器
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
