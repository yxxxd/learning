package com.yxd.zkregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkregistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkregistryApplication.class, args);
    }

}
