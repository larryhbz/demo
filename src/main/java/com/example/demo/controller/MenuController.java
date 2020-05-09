package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/menu/")
public class MenuController {
    @RequestMapping("main")
    public String main(Map<String,String> map){
        return "yemian/index";
    }

    @RequestMapping("login")
    public String login(Map<String,String> map){
        return "login/index";
    }
}
