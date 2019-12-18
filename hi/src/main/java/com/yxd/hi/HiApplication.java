package com.yxd.hi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiApplication.class, args);
    }

}
