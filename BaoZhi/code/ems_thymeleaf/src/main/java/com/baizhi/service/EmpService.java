package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/4 19:49
 * @Version 1.0
 */
public interface EmpService {

    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

    Emp find(String id);

    void updata(Emp emp);
}
