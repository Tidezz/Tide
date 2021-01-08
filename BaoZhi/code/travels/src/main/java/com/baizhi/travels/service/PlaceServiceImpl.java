package com.baizhi.travels.service;

import com.baizhi.travels.dao.PlaceDAO;
import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/7 10:32
 * @Version 1.0
 */
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDAO placeDAO;

    @Autowired
    ProvinceService provinceService;

    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {
        int start = (page - 1) * rows;
        return placeDAO.findByProvinceIdPage(start, rows, provinceId);
    }

    @Override
    public Integer findByProvinceIdCounts(String provinceId) {
        return placeDAO.findByProvinceIdCounts(provinceId);
    }

    @Override
    public void save(Place place) {
        //保存景点
        placeDAO.save(place);
        //查询原有的省份信息
        Province province = provinceService.findOne(place.getProvinceid());
        //更新省份信息--》景点数加一
        province.setPlacecounts(province.getPlacecounts() + 1);
        provinceService.update(province);
    }
}
