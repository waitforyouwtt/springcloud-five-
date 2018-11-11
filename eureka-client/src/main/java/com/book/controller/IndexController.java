package com.book.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2018/11/11 18:50
 * @Version 1.0
 */
@RestController
public class IndexController {

    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    public String home(@RequestParam String name){
        return "hi:"+name+"how are you?"+port;
    }

}
