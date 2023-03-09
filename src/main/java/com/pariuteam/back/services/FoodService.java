package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.repositories.FoodRepository;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired CategoriesService categoriesService;
    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }

    public Food addFood(FoodRequestBody foodRequestBody) {

        Food food = new Food();
        food.setFoodId(foodRequestBody.getFoodId());
        food.setFoodName(foodRequestBody.getFoodName());
        food.setScientificFoodName(foodRequestBody.getScientificFoodName());
        food.setCategory(categoriesService.getCategorie(foodRequestBody.getCategoryId()));
        food.setSubCategory(categoriesService.getSubCategorie(foodRequestBody.getSubCategoryId()));
        food.setSubSubCategory(categoriesService.getSubSubCategorie(foodRequestBody.getSubCategoryId()));

        return foodRepository.save(food);
    }
}
