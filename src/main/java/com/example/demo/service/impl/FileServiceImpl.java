package com.example.demo.service.impl;

import com.example.demo.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void uploadFile(MultipartFile myfiles, HttpServletRequest request, HttpServletResponse response) {
        String fileName = myfiles.getOriginalFilename();
        int size = (int) myfiles.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:/fileSave" ;
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        File dest = new File(path + "/"+date + "/"+ fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            myfiles.transferTo(dest); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
