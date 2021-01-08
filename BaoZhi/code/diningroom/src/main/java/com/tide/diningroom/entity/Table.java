package com.tide.diningroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author 杨凯
 * @date 2020/5/10 17:44
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Table {
    private int id;
    private String name;
    private int p_num;
    private int state;
}
