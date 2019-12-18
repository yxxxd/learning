package com.yxd.hi.service;

import com.yxd.hi.entity.User;

/**
 * @author yuxudong
 * @date 2019/9/25 16:46
 */
public interface UserService {
    User create(String username, String password);

    User authentication(String username, String password);
}
