package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
//        获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构建新的文件名
        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        String director = "D:\\project\\java-study\\tlias\\src\\main\\resources\\static\\images\\" + newFileName;

        //将文件保存到目录下
        image.transferTo(new File(director));

        return  Result.success(director);
    }
}
