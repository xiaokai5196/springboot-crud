package com.dict.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 也可直接implements WebMvcConfigurer，然后重写接口内方法
 */

@Configuration
public class WebMvcConfig {

    /*配置一个首页视图解析器*/
    @Bean
    public WebMvcConfigurer createWebMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
            }
        };
        return webMvcConfigurer;
    }
}
