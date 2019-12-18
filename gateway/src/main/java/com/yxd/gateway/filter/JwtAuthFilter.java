package com.yxd.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuxudong
 * @date 2019/10/12 13:57
 */
//@Component
//public class JwtAuthFilter extends AbstractGatewayFilterFactory<Object> {
//
//
//    @Value("#{'${url.ignore}'.split(',')}")
//    private List<String> ignoreUrl;
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            String jwtToken = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//            // 校验token合法性
//            String path = exchange.getRequest().getURI().getPath();
//
//            boolean flag = false;
//            System.out.println("path: " + path);
//            if (ignoreUrl.contains(path)) {
//                System.out.println("ignoreUrl: " + path);
//                flag = true;
//            }
//
//            if (!StringUtils.isEmpty(jwtToken) || flag){
//                System.out.println("token: " + jwtToken);
//                return chain.filter(exchange);
//            }
//
//            System.out.println("==================请求拦截==================");
//            // 封装错误信息
//            Map<String, Object> responseData = new HashMap<>(8);
//            responseData.put("code", 401);
//            responseData.put("message", "非法请求");
//            responseData.put("cause", "Token is empty");
//
//            try {
//                // 将信息转换为 JSON
//                ObjectMapper objectMapper = new ObjectMapper();
//                byte[] data = objectMapper.writeValueAsBytes(responseData);
//                ServerHttpResponse response = exchange.getResponse();
//                // 输出错误信息到页面
//                DataBuffer buffer = response.bufferFactory().wrap(data);
//                response.setStatusCode(HttpStatus.UNAUTHORIZED);
//                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//                return response.writeWith(Mono.just(buffer));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return chain.filter(exchange);
//        };
//    }
//
//
//}
//