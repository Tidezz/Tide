package com.baizhi.travels.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/6 15:57
 * @Version 1.0
 */
public interface BaseDAO<T, K> {
    void save(T t);

    void update(T t);

    void delete(K k);

    List<T> findAll();

    T findOne(K k);

    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotals();

}
