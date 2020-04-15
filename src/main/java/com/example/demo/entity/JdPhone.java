package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
