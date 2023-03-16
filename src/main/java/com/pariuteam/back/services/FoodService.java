package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.repositories.FoodRepository;
import com.pariuteam.back.requestBodies.FilteredField;
import com.pariuteam.back.requestBodies.FilteredFoodRequestBody;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        food.setSubSubCategory(categoriesService.getSubSubCategorie(foodRequestBody.getSubSubCategoryId()));

        return foodRepository.save(food);
    }

    public List<Food> getFoodList(FilteredFoodRequestBody filteredFoodRequestBody){
        List<Food> list = getAllFoods();
        
        if(filteredFoodRequestBody.getFilters()!=null)
            for(String fieldName : filteredFoodRequestBody.getFilters().keySet()){
                list = FilteredField.FOOD_FILTER_METHODS().get(fieldName).filter(list,filteredFoodRequestBody.getFilters().get(fieldName));
            }

        return list;
    }
}
