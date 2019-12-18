package com.yxd.websocket.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuxudong
 * @date 2019/9/27 13:51
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{code}")
public class WebSocketServer {
    /**
     * 记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 保存当前WebSocket
     */
    private static ConcurrentHashMap<String, Session> SessionMap = new ConcurrentHashMap<>(16);

    /**
     * 连接建立成功
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("code") String code, Session session) {
        // 保存session
        SessionMap.put(code, session);
        // 连接数加一
        onlineCount.incrementAndGet();
        log.info("【websocket消息】 有新连接加入！当前连接数数为" + onlineCount.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //在线数减1
        onlineCount.decrementAndGet();
        log.info("【websocket消息】 有一连接关闭！当前连接数数为" + onlineCount.get());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("【websocket消息】 发生错误");
        error.printStackTrace();
    }


    @OnMessage
    public void onMessage(String message){
        System.out.println("【websocket消息】 收到客户端发来的消息："+message);
        log.info("【websocket消息】 收到客户端发来的消息：{}",message);
    }


    public void sendMessage(String code, String message) throws IOException {
        log.info("【websocket消息】 向客户端发送消息：" + message);

        if (SessionMap.get(code) != null) {
            SessionMap.get(code).getBasicRemote().sendText(message);
        }
    }
}
