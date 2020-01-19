package com.tbryant.springmvctest.demo.core;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan("com.tbryant.springmvctest.demo")
// 注解方式驱动springmvc，等同于<annotation:driver>
// 不加不会解析WebMvcConfigurer接口
// 如果不加@EnableWebMvc，就要改成extends WebMvcConfigurationSupport
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
	// 配置视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/page/",".html");
	}
	// 配置消息转换器 这里用fastjson，可以自由选择
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
		converters.add(fastJsonHttpMessageConverter);
	}
}
