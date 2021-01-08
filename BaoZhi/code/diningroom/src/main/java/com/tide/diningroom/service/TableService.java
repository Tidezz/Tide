package com.tide.diningroom.service;

import com.tide.diningroom.entity.Province;
import com.tide.diningroom.entity.Table;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/10 17:52
 * @Version 1.0
 */
public interface TableService {
    /**
     * 参数1：当前页  //参数2：每页显示记录数
     */

    List<Table> findByPage(Integer page, Integer rows);

    /**
     * 查询总条数
     */
    Integer findTotals();
}
