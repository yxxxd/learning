package com.yxd.auth2.dao;

import com.yxd.auth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuxudong
 * @date 2019/9/25 15:12
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
