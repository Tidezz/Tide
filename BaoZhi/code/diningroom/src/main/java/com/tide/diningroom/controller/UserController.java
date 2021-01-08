package com.tide.diningroom.controller;

import com.tide.diningroom.entity.Result;
import com.tide.diningroom.entity.User;
import com.tide.diningroom.service.UserService;
import com.tide.diningroom.utils.ValidateImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author 杨凯
 * @date 2020/5/5 19:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
@CrossOrigin    //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        try {
            try {
                User userDB = userService.login(user);
                //登陆成功后保存用户的标记 ，不使用ServletContext application作用域，因为当作用域中的数据增多时会占用服务器资源
                //通常使用 Redis 使用 userId 的值存放 userDB
                request.getServletContext().setAttribute(userDB.getId(), userDB);
                result.setMsg("登陆成功！");
            } catch (Exception e) {
                result.setState(false);
                result.setMsg(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setState(false);
        }
        return result;
    }


    /**
     * 用户注册
     *
     * @param code
     * @param user
     * @return
     * @RequestBody User user 用来接收由 axiso 传的 user 对象
     */
    @PostMapping("register")
    @ResponseBody
    public Result register(String code, String key, @RequestBody User user, HttpServletRequest request) {

        Result result = new Result();

        String keyCode = (String) request.getServletContext().getAttribute(key);
        try {
            if (code.equalsIgnoreCase(keyCode)) {
                //注册用户
                userService.register(user);
                result.setMsg("注册成功！");
            } else {
                throw new RuntimeException("验证码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setState(false);
        }
        return result;
    }


    /**
     * 获取验证码
     *
     * @param request
     * @throws IOException
     */
    @GetMapping("getImage")
    @ResponseBody
    public Map<String, String> getImage(HttpServletRequest request) throws IOException {

        Map<String, String> result = new HashMap<>();
        //获取验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //存入session
        //生成唯一时间戳 key
        String key = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key, securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //响应浏览器
        //进行 base64 编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key", key);
        result.put("image", string);
        return result;
    }
}
