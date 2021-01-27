package com.kl.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 教师模块启动类
 * @Author: 可乐
 * @Date: 21:56 2021/1/26
 */
@SuppressWarnings("all")
@SpringBootApplication
@ComponentScan(basePackages = {"com.kl"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
















