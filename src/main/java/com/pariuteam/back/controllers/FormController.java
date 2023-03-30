package com.pariuteam.back.controllers;

import com.pariuteam.back.models.FavouriteFood;
import com.pariuteam.back.repositories.FavouriteFoodRepository;
import com.pariuteam.back.requestBodies.FormBody;
import com.pariuteam.back.services.FoodService;
import com.pariuteam.back.services.FormService;
import com.pariuteam.back.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;
    @Autowired
    private FavouriteFoodRepository favouriteFoodRepository;
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @PostMapping
    private ResponseEntity<FormBody> registerForm(@RequestBody @Valid FormBody formBody){
        return ResponseEntity.ok().body(formService.registerForm(formBody));
    }
    @PostMapping("/slt")
    private FavouriteFood registerForm() {
        favouriteFoodRepository.save(new FavouriteFood(foodService.getFood(1001L), userService.getUser(301L)));
        return null;
    }
}
