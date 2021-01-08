package com.baizhi.travels.controller;

import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Result;
import com.baizhi.travels.service.PlaceService;
import lombok.Data;
import lombok.val;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.executor.ResultExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨凯
 * @date 2020/5/7 10:34
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Value("${upload.dir}")
    private String realPath;

    /**
     * 保存景点信息
     *
     * @param pic
     * @return
     */
    @PostMapping("save")
    public Result save(MultipartFile pic, Place place) throws IOException {

        Result result = new Result();

        System.out.println("Tide-->" + pic.getOriginalFilename());
        System.out.println("Tide-->" + place);

        //文件上传
        try {
            String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
            String newFileName = new SimpleDateFormat("yyyMMddHHmmss").format(new Date()) + extension;
            //base64 编码处理
            place.setPicpath(Base64Utils.encodeToString(pic.getBytes()));
            //文件长传
            File file = new File(realPath);
            pic.transferTo(new File(file, newFileName));
            //保存place对象
            placeService.save(place);
            result.setMsg("添加景点成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("添加景点信息失败！");
            result.setState(false);
        }
        return result;
    }

    /**
     * 根据省份id查询景点的方法
     *
     * @param page
     * @param rows
     * @param provinceId
     * @return
     */
    @GetMapping("findAllPlace")
    public Map<String, Object> findAllPlace(Integer page, Integer rows, String provinceId) {

        HashMap<String, Object> result = new HashMap<>();
        page = page == null ? 1 : page;
        rows = rows == null ? 3 : rows;
        //景点集合
        List<Place> places = placeService.findByProvinceIdPage(page, rows, provinceId);
        //处理分页
        Integer counts = placeService.findByProvinceIdCounts(provinceId);
        //总页数
        Integer totalPage = counts % rows == 0 ? counts / rows : counts / rows + 1;

        result.put("places", places);
        result.put("page", page);
        result.put("counts", counts);
        result.put("totalPage", totalPage);

        return result;
    }
}
