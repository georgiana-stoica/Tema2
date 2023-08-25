package com.example.florarie.controller;

import com.example.florarie.model.Order;
import com.example.florarie.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
     private final OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrderList();
    }

}
