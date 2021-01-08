package com.baizhi.travels.entity;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getPlacecounts() {
        return placecounts;
    }

    public void setPlacecounts(Integer placecounts) {
        this.placecounts = placecounts;
    }
}