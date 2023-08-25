package com.example.florarie.controller;

import com.example.florarie.model.Flower;
import com.example.florarie.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/flowers")
public class FlowerController {

    private final FlowerService flowerService;

    @GetMapping
    public List<Flower> getFlowers(){
        return flowerService.getFlowerList();
    }

    @PostMapping
    public void createFlower(@RequestBody Flower flower){
        flowerService.saveFlower(flower);
    }

    @PutMapping
    public void updateFlower(@RequestBody Flower flower){
        flowerService.updateFlower(flower);
    }

    @PostMapping("buy")
    public void buyFlower(@RequestParam("flowerID") Long flowerID, @RequestParam("quantity") Long quantity){
        flowerService.buyFlower(flowerID,quantity);
    }
}
