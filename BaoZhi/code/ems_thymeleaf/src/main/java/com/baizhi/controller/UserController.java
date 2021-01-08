package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.ValidateImageCodeUtils;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author 杨凯
 * @date 2020/5/4 16:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录功能
     */
    @PostMapping("/login")
    public String login(String username, String password) {
        User login = userService.login(username, password);
        if (login != null) {
            //跳转到查询所有
            return "redirect:/emp/findAll";
        } else {
            //跳转回到登录
            return "redirect:/index";
        }
    }

    /**
     * 注册方法
     */
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session) {

        //跳转到登录界面
        String sessionCode = (String) session.getAttribute("code");
        //忽略大小写比较
        if (sessionCode.equalsIgnoreCase(code)) {
            userService.register(user);
            return "redirect:/index";
        } else {
            return "redirect:/toRegister";
        }

    }

    /**
     * 生成验证码
     */
    @GetMapping("code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        //获得验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //将验证码错存入session作用域中
        session.setAttribute("code", securityCode);

        //响应图片
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
    }
}
