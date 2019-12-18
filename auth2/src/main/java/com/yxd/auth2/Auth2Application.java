package com.yxd.auth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * EnableResourceServer： 开启资源服务，因为程序需要对外暴露token的API接口
 */
@EnableEurekaClient
@EnableResourceServer
@SpringBootApplication
public class Auth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Auth2Application.class, args);
    }

}
