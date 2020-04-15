package com.example.demo.service.impl;

import com.example.demo.entity.JdPhone;
import com.example.demo.mapper.JdPhoneMapper;
import com.example.demo.service.JdPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdPhoneServiceImpl implements JdPhoneService {
    @Autowired
    private JdPhoneMapper jdPhoneMapper;
    @Override
    public boolean save(JdPhone jdPhone) {
        return false;
    }

    @Override
    public List<JdPhone> findlist() {
        List<JdPhone> list  = jdPhoneMapper.findlist();
        return list;
    }
}
