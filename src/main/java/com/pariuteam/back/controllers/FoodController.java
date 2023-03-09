package com.pariuteam.back.controllers;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import com.pariuteam.back.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods(){
        return ResponseEntity.ok().body(foodService.getAllFoods());
    }

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody FoodRequestBody foodRequestBody){
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.addFood(foodRequestBody));
    }

}
