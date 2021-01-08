package com.tide.diningroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author 杨凯
 * @date 2020/5/5 20:58
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Result {
    private Boolean state = true;
    private String msg;
    private String userId;
}
