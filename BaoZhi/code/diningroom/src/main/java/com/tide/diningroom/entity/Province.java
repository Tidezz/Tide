package com.tide.diningroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author 杨凯
 * @date 2020/5/6 15:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Province {
    private String id;
    private String name;
    private String tags;
    private Integer placecounts;

}