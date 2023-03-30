package com.pariuteam.back.services;

import com.pariuteam.back.models.FavouriteFood;
import com.pariuteam.back.models.User;
import com.pariuteam.back.repositories.FavouriteFoodRepository;
import com.pariuteam.back.requestBodies.FormBody;
import com.pariuteam.back.responseBodies.UserResponseBody;
import com.pariuteam.back.responseBodies.mappers.UserResponseMapper;
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
        User user = userService.addUser(formBody.getUser());
        formBody.getListeAliments().stream().forEach(foodId -> {
            FavouriteFood favouriteFood = new FavouriteFood(foodService.getFood(Long.valueOf(foodId)), userService.getUser(user.getUserId()));
            favouriteFoodRepository.save(favouriteFood);
        }
    );
        return formBody;
    }
}
