package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 杨凯
 * @date 2020/5/4 16:16
 * @Version 1.0
 */
public interface UserDAO {

    void save(User user);

    /**
     * 传递多个参数时要做数据绑定
     *
     * @param username
     * @param password
     */
    User login(@Param("username") String username, @Param("password") String password);
}
