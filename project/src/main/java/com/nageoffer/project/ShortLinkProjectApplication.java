package com.nageoffer.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.nageoffer.project.dao.mapper")
public class ShortLinkProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkProjectApplication.class,args);
    }
}