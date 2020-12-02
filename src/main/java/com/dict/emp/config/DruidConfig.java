package com.dict.emp.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DruidConfig {

    /**
     * 数据源配置
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDruidDataSource(){
        return new DruidDataSource();
    }


    /**
     * 配置druid管理后台servlet
     * http://localhost:8088/crud/druid/
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //管理后台登录用户名和密码
        bean.setEnabled(true);
        bean.addInitParameter("loginUsername","admin");
        bean.addInitParameter("loginPassword","zxk@5196");
        //允许的访问地址，默认允许所有
        bean.addInitParameter("allow","127.0.0.1");
        return bean;
    }

    /**
     * 配置web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        bean.setEnabled(true);
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }

}
