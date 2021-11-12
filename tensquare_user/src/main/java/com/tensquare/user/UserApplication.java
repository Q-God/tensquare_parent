package com.tensquare.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @version v1.0
 * @ClassName UserApplication
 * @Description TODO
 * @Author Q
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.tensquare.user.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    Executor exec = Executors.newCachedThreadPool();
}
