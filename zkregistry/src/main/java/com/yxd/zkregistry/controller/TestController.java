package com.yxd.zkregistry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuxudong
 * @date 2019/12/12 21:02
 */
@RestController
public class TestController {
    @RequestMapping("test")
    public String test(){
        return "success";
    }


}
