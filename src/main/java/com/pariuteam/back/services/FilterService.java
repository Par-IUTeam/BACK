package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.requestBodies.FoodFilterMethod;
import lombok.Getter;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Getter
public enum FilterService{
    NAME(FOOD_FILTER_METHODS().get("name")) ,
    CATEGORY(FOOD_FILTER_METHODS().get("category")),
    SUB_CATEGORY(FOOD_FILTER_METHODS().get("subCategory")),
    SUB_SUB_CATEGORY(FOOD_FILTER_METHODS().get("subSubCategory"));

    private FoodFilterMethod foodFilterMethod;
    FilterService(FoodFilterMethod foodFilterMethod) {
        this.foodFilterMethod = foodFilterMethod;
    }

   public static HashMap<String,FoodFilterMethod> FOOD_FILTER_METHODS(){
        HashMap<String,FoodFilterMethod> hashMap = new HashMap<>();
        hashMap.put("name", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getFoodName().contains(value)).collect(Collectors.toList());
            }
        });
        hashMap.put("category", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
               return list.stream().filter(food -> food.getCategory().getCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
        hashMap.put("subCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
               return list.stream().filter(food -> food.getSubCategory().getSubCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
        hashMap.put("subSubCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getSubSubCategory().getSubSubCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
        return hashMap;
    }

}

