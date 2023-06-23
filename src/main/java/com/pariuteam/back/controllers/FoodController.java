package com.pariuteam.back.controllers;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.requestBodies.FilteredFoodRequestBody;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import com.pariuteam.back.responseBodies.FoodResponse;
import com.pariuteam.back.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin("http://localhost:4200/")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods(){
        return ResponseEntity.ok().body(foodService.getAllFoods());
    }
    @GetMapping("/filtered")
    public ResponseEntity<List<FoodResponse>> getFilteredFood(@RequestBody FilteredFoodRequestBody filteredFoodRequestBody){
        return ResponseEntity.ok().body(foodService.getFoodList(filteredFoodRequestBody));
    }
    @PostMapping("/add")
    public ResponseEntity<FoodResponse> addFood(@RequestBody FoodRequestBody foodRequestBody){
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.addFood(foodRequestBody));
    }


}
