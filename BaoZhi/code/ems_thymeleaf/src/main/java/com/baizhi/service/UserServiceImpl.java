package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author 杨凯
 * @date 2020/5/4 16:20
 * @Version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        //设置主键
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
