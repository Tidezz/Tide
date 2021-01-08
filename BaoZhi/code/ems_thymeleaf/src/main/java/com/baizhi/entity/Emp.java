package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author 杨凯
 * @date 2020/5/4 18:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {

    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;
}
