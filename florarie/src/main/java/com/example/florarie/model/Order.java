package com.example.florarie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Long flowerId;
    private Long quantity;//cantitatea cumparata
    private Double price;
}
