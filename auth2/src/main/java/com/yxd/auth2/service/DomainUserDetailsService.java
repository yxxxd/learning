package com.yxd.auth2.service;

import com.yxd.auth2.dao.UserDao;
import com.yxd.auth2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yuxudong
 * @date 2019/9/26 11:11
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User account = userDao.findByUsername(username);
        if (account != null){
            return account;
        }else {
            throw  new UsernameNotFoundException("用户["+username+"]不存在");
        }
    }
}
