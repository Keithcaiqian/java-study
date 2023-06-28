package com.kun.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/simpleParam")
    public String simpleParam(){
        return "ok";
    }
}
