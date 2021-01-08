package com.tide.diningroom.service;

import com.tide.diningroom.dao.TableDAO;
import com.tide.diningroom.entity.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 杨凯
 * @date 2020/5/10 17:54
 * @Version 1.0
 */
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDAO tableDAO;

    @Override
    public List<Table> findByPage(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        return tableDAO.findByPage(start, rows);
    }

    @Override
    public Integer findTotals() {
        return tableDAO.findTotals();
    }
}
