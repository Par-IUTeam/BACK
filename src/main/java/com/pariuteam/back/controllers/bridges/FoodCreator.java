package com.pariuteam.back.controllers.bridges;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import com.pariuteam.back.services.CategoryService;

public class FoodCreator {

    public static Food create(CategoryService categoryService, FoodRequestBody foodBody) {

        Food food = new Food();
        food.setFoodId(foodBody.getFoodId());
        food.setFoodName(foodBody.getFoodName());
        food.setScientificFoodName(foodBody.getScientificFoodName());
        food.setCategory(categoryService.getCategory(foodBody.getCategoryId()));
        food.setSubCategory(categoryService.getSubCategory(foodBody.getSubCategoryId()));
        food.setSubSubCategory(categoryService.getSubSubCategory(foodBody.getSubSubCategoryId()));

        return food;
    }

}
