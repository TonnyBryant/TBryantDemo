package com.tbryant.springmvctest.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

public class Application {
    public static void main(String[] args) throws Exception {
        // 内置tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
        // 添加生命周期监听器
        context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
        tomcat.start();
        tomcat.getServer().await();
    }
}