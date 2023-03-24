package com.pariuteam.back.controllers;

import com.pariuteam.back.repositories.FavouriteFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class FavouriteFoodController {
    @Autowired
    private FavouriteFoodRepository favouriteFoodRepository;

    @GetMapping("/favs")
    private List<List<String>> getAll(){
        return favouriteFoodRepository.findAll().stream().map(x->{
            return List.of(x.getFood().getFoodName(),x.getUser().getUserName());
        }).collect(Collectors.toList());
    }
}
