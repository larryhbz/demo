package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @RequestMapping("index")
    public String index(Map<String,String> map){
        return "login/index";
    }

    @PostMapping("login")
    @ResponseBody
    public boolean login(@RequestBody UserEntity userEntity){
        return loginService.login(userEntity);
    }
}
