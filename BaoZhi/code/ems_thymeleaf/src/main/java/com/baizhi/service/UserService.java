package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * @Author 杨凯
 * @date 2020/5/4 16:19
 * @Version 1.0
 */
public interface UserService {

    void register(User user);

    User login(String username, String password);
}
