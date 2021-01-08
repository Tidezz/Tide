package com.tide.diningroom.service;


import com.tide.diningroom.entity.Province;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/6 16:05
 * @Version 1.0
 */
public interface ProvinceService {

    //参数1：当前页  //参数2：每页显示记录数
    List<Province> findByPage(Integer page, Integer rows);

    //查询总条数
    Integer findTotals();

    //保存省份
    void save(Province province);

    //省份删除
    void delete(String id);

    //查询一条省份信息
    Province findOne(String id);

    //修改省份信息
    void update(Province province);
}
