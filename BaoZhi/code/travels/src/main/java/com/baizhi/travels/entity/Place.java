package com.baizhi.travels.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

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

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public Date getHottime() {
        return hottime;
    }

    public void setHottime(Date hottime) {
        this.hottime = hottime;
    }

    public Double getHotticket() {
        return hotticket;
    }

    public void setHotticket(Double hotticket) {
        this.hotticket = hotticket;
    }

    public Double getDimticket() {
        return dimticket;
    }

    public void setDimticket(Double dimticket) {
        this.dimticket = dimticket;
    }

    public String getPlacedes() {
        return placedes;
    }

    public void setPlacedes(String placedes) {
        this.placedes = placedes;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
