package com.yxd.websocket.controller;

import com.yxd.websocket.utils.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuxudong
 * @date 2019/9/27 14:13
 */
@RestController()
@RequestMapping("test")
public class TestController {
    @Autowired
    private WebSocketServer webSocketServer;

    @GetMapping("sendMessage/{code}")
    public String sendMessage(@PathVariable("code") String code){
        for (int i=0;i<100;i=i+5) {
            try {
                webSocketServer.sendMessage(code, ""+i);
                TimeUnit.SECONDS.sleep(2);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "发送成功";
    }

    public static void main(String[] args) {
        int n = 1000000;
        for (int i=0;i<=1000000;i++){
            if (((i*100.0)/(n*1.0))%5==0) {
                System.out.println(i);
            }
        }
    }
}
