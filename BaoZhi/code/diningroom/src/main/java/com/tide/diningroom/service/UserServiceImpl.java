package com.tide.diningroom.service;

import com.tide.diningroom.dao.UserDAO;
import com.tide.diningroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 杨凯
 * @date 2020/5/5 20:41
 * @Version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
//        userDAO.findByUsername(user.getUsername()) == null
        if (userDAO.findByUsername(user.getUsername()) == null) {
            userDAO.save(user);
        } else {
            throw new RuntimeException("用户名已存在!!!");
        }

    }

    @Override
    public User login(User user) {
        User userDB = userDAO.findByUsername(user.getUsername());
        if (userDB != null) {
            if (userDB.getPassword().equals(user.getPassword())) {
                return userDB;
            } else {
                throw new RuntimeException("密码输入错误!");
            }
        } else {
            throw new RuntimeException("用户名不存在!");
        }
    }
}
