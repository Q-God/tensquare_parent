package com.tensquare.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version v1.0
 * @ClassName BaseApplication
 * @Description TODO
 * @Author Q
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tensquare.base.dao")
@EnableEurekaClient
@ComponentScan("com.tensquare")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
