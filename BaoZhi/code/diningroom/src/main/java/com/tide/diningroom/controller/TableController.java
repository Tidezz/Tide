package com.tide.diningroom.controller;

import com.tide.diningroom.entity.Table;
import com.tide.diningroom.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨凯
 * @date 2020/5/10 17:56
 * @Version 1.0
 */
@RestController
@RequestMapping("table")
@CrossOrigin
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("findByPage")
    @ResponseBody
    public Map<String, Object> findByPage(Integer page, Integer rows) {

        page = page == null ? 1 : page;
        rows = rows == null ? 5 : rows;

        HashMap<String, Object> map = new HashMap<>();
        //计算分页
        List<Table> tables = tableService.findByPage(page, rows);
        //计算总页数
        Integer totals = tableService.findTotals();

        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("tables", tables);
        map.put("totals", totals);
        map.put("totalsPage", totalPage);
        map.put("page", page);

        return map;
    }
}
