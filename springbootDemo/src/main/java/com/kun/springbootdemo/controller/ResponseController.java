package com.kun.springbootdemo.controller;

import com.kun.springbootdemo.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @RequestMapping("/hello")
    public Result hello() {
        return Result.success("Hello World ~");
    }
}
