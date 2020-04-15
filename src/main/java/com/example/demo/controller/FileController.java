package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public void selectUserList(@RequestParam("file") MultipartFile myfiles, HttpServletRequest request, HttpServletResponse response){
        fileService.uploadFile(myfiles,request,response);
    }
}
