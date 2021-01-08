package com.baizhi.travels.dao;

import com.baizhi.travels.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 杨凯
 * @date 2020/5/5 20:35
 * @Version 1.0
 */

@Mapper
public interface UserDAO {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 注册用户
     *
     * @param user
     */
    void save(User user);
}
