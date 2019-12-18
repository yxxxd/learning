package com.yxd.hi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author yuxudong
 * @date 2019/9/25 16:47
 */
@Slf4j
@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    /**
     * 不需要任何权限，只要Header中的Token正确即可
     */
    @RequestMapping("/hi")
    public String home() {
        return "hi :"+",i am from port:" +port;
    }

    /**
     * 需要ROLE_ADMIN权限
     */
    @PreAuthorize("hasAuthority('福建物联网管理员')")
    @RequestMapping("/hello")
    public String hello (){
        return "hello you!";
    }
    /**
     * 获取当前“Token”用户信息
     */
    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
                                             Authentication authentication){

        log.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        log.info(oAuth2Authentication.toString());
        log.info("principal.toString()"+principal.toString());
        log.info("principal.getName()"+principal.getName());
        log.info("authentication:"+authentication.getAuthorities().toString());

        return oAuth2Authentication;

    }
}
