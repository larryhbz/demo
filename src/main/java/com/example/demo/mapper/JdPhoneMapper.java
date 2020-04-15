package com.example.demo.mapper;

import com.example.demo.entity.JdPhone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JdPhoneMapper   {
    Boolean save(JdPhone jdPhone);
    List<JdPhone> findlist();
}
