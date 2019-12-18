package com.yxdx.es.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuxudong
 * @date 2019/11/18 15:54
 */
@RestController
@Slf4j
public class TestController {
    @RequestMapping("test")
    public void test(){
        System.out.println("test");
        log.info("<<<<<<<<<<<<<<<<<test>>>>>>>>>>>>>>>>>>>>");
    }
}
