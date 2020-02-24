package cn.com.wowgz.face_attendance_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Copyright (C), 2017-2020
 * Author: WowGz
 * Date: 2020/2/24/024 16:29
 * FileName: MyConfig
 * Description: My own configuration about this project
 */
@Configuration
public class MyConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
