package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/4 20:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    /**
     * 注入service对象
     */
    @Autowired
    private EmpService empService;

    /**
     * 查询所有
     *
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "ems/emplist";
    }

    /**
     * 保存员工信息
     *
     * @param emp
     * @return
     */
    @PostMapping("/save")
    public String save(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String delete(String id) {
        empService.delete(id);
        return "redirect:/emp/findAll";
    }

    /**
     * 查询员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("/find")
    public String find(String id, Model model) {
        Emp emp = empService.find(id);
        model.addAttribute("emp", emp);
        return "/ems/updateEmp";
    }

    /**
     * 更新员工信息
     *
     * @param emp
     * @return
     */
    @PostMapping("/update")
    public String update(Emp emp) {
        empService.updata(emp);
        return "redirect:/emp/findAll";
    }

}
