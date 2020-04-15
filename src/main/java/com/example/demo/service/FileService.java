package com.example.demo.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
    void uploadFile(MultipartFile myfiles, HttpServletRequest request, HttpServletResponse response);
}
