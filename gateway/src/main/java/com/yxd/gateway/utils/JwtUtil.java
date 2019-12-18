package com.yxd.gateway.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author yuxudong
 * @date 2019/10/12 10:08
 */
public class JwtUtil {
    /**
     * 密钥
     */
    private static final String SECRET_KEY = "123456";

    /**
     * token过期时间
     */
    private static final long TOKEN_EXPIRE_TIME = 5*60*1000;

    /**
     * refreshToken过期时间
     */
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 10*60*1000;

    /**
     * 签发人
     */
    private static final String ISSURE = "yuxudong";

    /**
     * 生成签名R
     * @param username 用户名
     * @return token
     */
    public static String generateToken(String username){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                // 签发人
                .withIssuer(ISSURE)
                // 签发时间
                .withIssuedAt(new Date())
                // 过期时间
                .withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRE_TIME))
                // 保存身份标识
                .withClaim("username", username)
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     * @param token 签名
     * @return 是否验证成功
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSURE)
                    .build();
            verifier.verify(token);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 从Token中获取username
     * @param token 签名
     * @return username
     */
    public static String getUsername(String token){
        try {
            return JWT.decode(token).getClaim("username").asString();
        } catch (Exception e){
            return "";
        }
    }

    private JwtUtil(){}
}
