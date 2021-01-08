package com.baizhi.travels.service;

import com.baizhi.travels.entity.Place;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/7 10:31
 * @Version 1.0
 */
public interface PlaceService {

    List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId);

    Integer findByProvinceIdCounts(String provinceId);

    void save(Place place);
}
