package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2018/11/12 23:36
 * @Version 1.0
 */
@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/test-ribbon")
    public String testRibbon(){
        ServiceInstance serviceInstance = loadBalancer.choose("eureka-client");
        return serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
