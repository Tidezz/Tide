package com.baizhi.dao;

import com.baizhi.entity.Emp;
import com.baizhi.entity.User;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/4 19:28
 * @Version 1.0
 */
public interface EmpDAO {

    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

    Emp find(String id);

    void update(Emp emp);
}
