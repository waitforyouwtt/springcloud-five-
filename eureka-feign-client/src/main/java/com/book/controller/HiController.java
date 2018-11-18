package com.book.controller;

import com.book.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2018/11/18 11:49
 * @Version 1.0
 */
@RestController
public class HiController {

    @Autowired
    HiService hiService;
    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "jie",required = false) String name){
        return hiService.sayHi(name);
    }
}
