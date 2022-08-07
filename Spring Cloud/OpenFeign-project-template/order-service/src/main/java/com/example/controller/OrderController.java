package com.example.controller;

import com.example.domain.Order;
import com.example.feign.OrderFeign;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderFeign {
    @Override
    public Order getOrderById(String id) {
        Order order = Order.builder().id("123").name("鸡腿").price(123D).build();
        return order;
    }
}
