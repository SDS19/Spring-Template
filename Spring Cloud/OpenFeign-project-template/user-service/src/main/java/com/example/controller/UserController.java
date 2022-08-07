package com.example.controller;

import com.example.domain.Order;
import com.example.feign.OrderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    public OrderFeign orderFeign;

    @GetMapping("/user")
    public Order getOrder(){
        return orderFeign.getOrderById("1");
    }
}
