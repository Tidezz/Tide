package com.tide.diningroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author 杨凯
 * @date 2020/5/5 20:22
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String email;

}
