package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JdPhone {
    private Integer id;
    private String name;
    private String price;
    private String tupian;
    private Date createTime;
    private Date modifiedTime;
}
