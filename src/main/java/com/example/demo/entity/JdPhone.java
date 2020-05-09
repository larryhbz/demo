package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("jd_phone")
public class JdPhone {
    private Integer id;
    private String name;
    private String price;
    private String tupian;
    private Date createTime;
    private Date modifiedTime;
}
