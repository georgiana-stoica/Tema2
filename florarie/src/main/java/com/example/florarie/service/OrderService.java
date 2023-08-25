package com.example.florarie.service;

import com.example.florarie.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class OrderService {

    private final List<Order> orderList = new ArrayList<>();

    public void saveOrder( Order order){
        orderList.add(order);
    }

}
