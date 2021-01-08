package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/7 10:03
 * @Version 1.0
 */

@Mapper
public interface PlaceDAO extends BaseDAO<Place, String> {

    List<Place> findByProvinceIdPage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("provinceId") String provinceId);

    Integer findByProvinceIdCounts(String provinceId);
}
