package com.ks.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @Author: 可乐
 * @Date: 22:02 2021/1/26
 */
@SuppressWarnings("all")
@Configuration
@MapperScan("com.ks.eduservice.mapper")
public class EduConfig {
}
