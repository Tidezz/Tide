package com.tide.diningroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author 杨凯
 * @date 2020/5/7 9:58
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Place {
    private String id;
    private String name;
    private String picpath;
    @JsonFormat(pattern = "yyyy-MM-dd--hh时")
    private Date hottime;
    private Double hotticket;
    private Double dimticket;
    private String placedes;
    private String provinceid;

}
