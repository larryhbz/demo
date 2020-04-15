package com.example.demo.utils;


import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.spider.HttpClientPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Scheduler {
    @Autowired
    private UserMapper userMapper;

    //每隔10秒执行一次
    @Scheduled(fixedRate = 100000)
    public void testTasks() {
        HttpClientPool pool=new HttpClientPool();
        List<UserEntity> list=userMapper.selectUserList();
        System.out.println("查询结果" +"" );
    }

    //每天3：05执行
    @Scheduled(cron = "0 05 03 ? * *")
    public void testTasks2() {

    }
}
