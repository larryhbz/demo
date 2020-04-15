package com.example.demo.service;

import com.example.demo.entity.JdPhone;

import java.util.List;

public interface JdPhoneService {
    boolean save(JdPhone jdPhone);
    List<JdPhone> findlist();
}
