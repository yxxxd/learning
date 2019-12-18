package com.yxd.auth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuxudong
 * @date 2019/9/25 16:01
 */
@RestController
@Slf4j
public class UserController {
    /**
     * 暴露 remote token services 接口
     * 如果其它服务需要验证 token，则需要远程调用授权服务暴露的验证 token 的 api 接口
     * @param principal
     * @return
     */
    @GetMapping("/user")
    public Principal getUser(Principal principal){
        return principal;
    }

    @GetMapping("/user-info")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.debug("user-me:{}", authentication.getName());
        return authentication;
    }

    @PreAuthorize("hasAuthority('福建物联网管理员')")
    @GetMapping("needAuth")
    public String test(){
        return "needAuth";
    }

    @PreAuthorize("hasAuthority('超级管理员')")
    @GetMapping("superAuth")
    public String test3(){
        return "superAuth";
    }

    @GetMapping("noAuth")
    public String test2(){
        return "noAuth";
    }
}
