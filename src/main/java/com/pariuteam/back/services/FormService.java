package com.pariuteam.back.services;

import com.pariuteam.back.models.FavouriteFood;
import com.pariuteam.back.repositories.FavouriteFoodRepository;
import com.pariuteam.back.requestBodies.FormBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private FavouriteFoodRepository favouriteFoodRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    public FormBody registerForm(@Valid FormBody formBody){
        userService.addUser(formBody.getUser());
        formBody.getListeAliments().stream().map(foodId -> favouriteFoodRepository.save(new FavouriteFood(foodService.getFood(foodId), formBody.getUser())));
        return formBody;
    }
}
