package com.yxd.hi.service.impl;

import com.yxd.hi.dao.UserDao;
import com.yxd.hi.entity.User;
import com.yxd.hi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author yuxudong
 * @date 2019/9/25 16:44
 */
@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;

    @Override
    public User create(String username, String password) {
        User user=new User();
        user.setUsername(username);
        String hash = ENCODER.encode(password);
        user.setPassword(hash);
        return userDao.save(user);

    }

    @Override
    public User authentication(String username, String password) {
        User u = userDao.findByUsername(username);
        if (u == null) {
            //throw new UsernameNotFoundException("用户不存在");
        }
        boolean res = new BCryptPasswordEncoder().matches(password, u.getPassword());
        if (res){
            return u;
        }
        return null;
    }
}
