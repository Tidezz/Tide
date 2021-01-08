package com.baizhi.travels.service;

import com.baizhi.travels.entity.User;

/**
 * @Author 杨凯
 * @date 2020/5/5 20:40
 * @Version 1.0
 */
public interface UserService {

    void register(User user);

    User login(User user);
}
