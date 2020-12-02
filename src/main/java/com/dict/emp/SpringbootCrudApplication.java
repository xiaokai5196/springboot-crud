package com.dict.emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dict.emp.mapper")
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }

}
