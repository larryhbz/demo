package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> selectUserList();
}
