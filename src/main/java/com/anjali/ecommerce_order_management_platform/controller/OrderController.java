package com.anjali.ecommerce_order_management_platform.controller;

import com.anjali.ecommerce_order_management_platform.dto.OrderRequestDto;
import com.anjali.ecommerce_order_management_platform.entity.CustomerOrder;
import com.anjali.ecommerce_order_management_platform.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public CustomerOrder placeOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.placeOrder(requestDto);
    }
}