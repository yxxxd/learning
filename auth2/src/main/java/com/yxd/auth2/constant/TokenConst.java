package com.yxd.auth2.constant;

/**
 * @author yuxudong
 * @date 2019/10/24 9:08
 */
public final class TokenConst {

    /**
     * token默认有效期 30秒
     */
    public static final int TOKEN_VALIDITY_SECONDS = 30*60;

    /**
     * refreshToken默认有效期 1天
     */
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 60*60*24;

    /**
     * 签名
     */
    public static final String SIGNING_KEY = "yuxd51";

    private TokenConst(){}
}
