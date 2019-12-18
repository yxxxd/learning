package com.yxd.zkregistry;

import org.apache.zookeeper.client.ZKClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZkregistryApplicationTests {
    private static final String ZOOKEEPER_IP_PORT = "106.52.101.109:2181";

    private ZKClientConfig clientConfig = new ZKClientConfig();

    @Test
    void contextLoads() {
    }

    void watchTest(){

    }

}
