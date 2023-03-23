package com.pariuteam.back.services;

import com.pariuteam.back.controllers.bridges.FoodCreator;
import com.pariuteam.back.models.Food;
import com.pariuteam.back.repositories.FoodRepository;
import com.pariuteam.back.requestBodies.FilteredField;
import com.pariuteam.back.requestBodies.FilteredFoodRequestBody;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    CategoryService categoryService;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food addFood(FoodRequestBody foodRequestBody) {
        Food food = FoodCreator.create(categoryService, foodRequestBody);
        return foodRepository.save(food);
    }

    public List<Food> getFoodList(FilteredFoodRequestBody filteredFoodRequestBody) {
        List<Food> list = getAllFoods();

        if (filteredFoodRequestBody.getFilters() != null) {
            for (String fieldName : filteredFoodRequestBody.getFilters().keySet()) {
                list = FilteredField.FOOD_FILTER_METHODS().get(fieldName).filter(list, filteredFoodRequestBody.getFilters().get(fieldName));
            }
        }

        return list;
    }
}
