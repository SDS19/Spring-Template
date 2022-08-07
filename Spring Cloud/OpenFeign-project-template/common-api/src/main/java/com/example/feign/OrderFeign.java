package com.example.feign;

import com.example.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service")
public interface OrderFeign {
    @GetMapping("{id}")
    Order getOrderById(@PathVariable String id);
}
