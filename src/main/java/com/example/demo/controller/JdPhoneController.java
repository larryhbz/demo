package com.example.demo.controller;

import com.example.demo.entity.JdPhone;
import com.example.demo.service.JdPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdphone")
public class JdPhoneController {
    @Autowired
    private JdPhoneService jdPhoneService;

    @GetMapping("/list")
    public List<JdPhone> selectUserList(){
        List<JdPhone> list=jdPhoneService.findlist();
        return list;
    }

    @PostMapping("/save")
    public boolean saveJdPhone(JdPhone jdPhone){
        return jdPhoneService.save(jdPhone);
    }
}
