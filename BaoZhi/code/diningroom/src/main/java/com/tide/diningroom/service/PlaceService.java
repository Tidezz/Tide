package com.tide.diningroom.service;

import com.tide.diningroom.entity.Place;

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
