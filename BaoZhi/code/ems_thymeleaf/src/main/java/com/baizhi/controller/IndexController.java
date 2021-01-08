package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 杨凯
 * @date 2020/5/4 15:48
 * @Version 1.0
 */

@Controller

public class IndexController {
    @GetMapping("/index")
    public String toIndex() {
        return "ems/login";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "/ems/regist";
    }

    @GetMapping("/toSave")
    public String toSave() {
        return "/ems/addEmp";
    }
}
