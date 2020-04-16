package com.example.demo.service.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(UserEntity userEntity) {
        Wrapper<UserEntity> wrapper=new EntityWrapper<>();
        wrapper.eq("name",userEntity.getName());
        wrapper.eq("password",userEntity.getPassword());
        Integer num=userMapper.selectCount(wrapper);
        if(num!=null){
            return true;
        }else{
            return false;
        }
    }
}
