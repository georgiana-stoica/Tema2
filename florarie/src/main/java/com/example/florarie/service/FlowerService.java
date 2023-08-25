package com.example.florarie.service;

import com.example.florarie.model.Flower;
import com.example.florarie.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerService {

    private final OrderService orderService;
    private final List<Flower> flowerList = new ArrayList<>();

    public void saveFlower(Flower flower){
        flower.setId((long)flowerList.size());
        flowerList.add(flower);
    }

    public List<Flower> getFlowerList(){
        return flowerList;
    }

    public void updateFlower(Flower flower){
        Flower selectedFlower = null;
        for( Flower flower1 : flowerList ){
            if( flower1.getId().equals(flower.getId()) ) {
                selectedFlower = flower1;
                break;
            }
        }

        if( selectedFlower == null ){
            return;
        }

        if( flower.getStock() != null ){
            selectedFlower.setStock(flower.getStock());
        }

        if( flower.getPrice() != null ){
            selectedFlower.setPrice(flower.getPrice());
        }

    }

    public void buyFlower( Long flowerId, Long quantity){
        Flower selectedFlower = null;
        for( Flower flower1 : flowerList ){
            if( flower1.getId().equals(flowerId) ) {
                selectedFlower = flower1;
                break;
            }
        }

        if( selectedFlower == null || selectedFlower.getStock() < quantity ){
            return;
        }
        selectedFlower.setStock(selectedFlower.getStock() - quantity);

        orderService.saveOrder( new Order((long)orderService.getOrderList().size(), flowerId, quantity, selectedFlower.getPrice() * quantity));
    }
}
