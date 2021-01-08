package com.tide.diningroom.service;

import com.tide.diningroom.dao.ProvinceDAO;
import com.tide.diningroom.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/6 16:08
 * @Version 1.0
 */
@Service
@Transactional
public class ProvinceServinceImpl implements ProvinceService {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Override
    public List<Province> findByPage(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        return provinceDAO.findByPage(start, rows);
    }

    @Override
    public Integer findTotals() {
        return provinceDAO.findTotals();
    }

    @Override
    public void save(Province province) {
        //初始景点个数为零
        province.setPlacecounts(0);
        provinceDAO.save(province);
    }

    @Override
    public void delete(String id) {
        provinceDAO.delete(id);
    }

    @Override
    public Province findOne(String id) {
        return provinceDAO.findOne(id);
    }

    @Override
    public void update(Province province) {
        provinceDAO.update(province);
    }
}
