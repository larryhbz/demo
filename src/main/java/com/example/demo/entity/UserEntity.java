package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserEntity {

    private Integer id;
    private String name;
    private String age;
    private String password;
    private String birthday;
    private String email;
    private String salt;
}
