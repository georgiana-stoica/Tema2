package com.example.florarie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private Long id;
    private String name;
    private Long stock;
    private Double price;

}
