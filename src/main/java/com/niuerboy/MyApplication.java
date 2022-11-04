package com.niuerboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 1:47
 * @DESCRIPTION :
 */

@SpringBootApplication(scanBasePackages={"com.niuerboy.bean","com.niuerboy.controller","com.niuerboy.dao","com.niuerboy.service.impl"})
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);
    }
}
