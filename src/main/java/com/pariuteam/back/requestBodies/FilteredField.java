package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;


import java.util.HashMap;
import java.util.stream.Stream;

public enum FilteredField{
    NAME(FOOD_FILTER_METHODS().get("name")),
    CATEGORY(FOOD_FILTER_METHODS().get("category")),
    SUB_CATEGORY(FOOD_FILTER_METHODS().get("subCategory")),
    SUB_SUB_CATEGORY(FOOD_FILTER_METHODS().get("subSubCategory"));




    FilteredField(FoodFilterMethod foodFilterMethod) {
    }

   public static HashMap<String,FoodFilterMethod> FOOD_FILTER_METHODS(){
        HashMap<String,FoodFilterMethod> hashMap = new HashMap<>();
        hashMap.put("name", new FoodFilterMethod() {
            @Override
            public Stream<Food> filter(Stream<Food> streamFood, String value) {
                streamFood.filter(food -> food.getFoodName().contains(value));
                return streamFood;
            }
        });
        hashMap.put("category", new FoodFilterMethod() {
            @Override
            public Stream<Food> filter(Stream<Food> streamFood, String value) {
                streamFood.filter(food -> food.getCategory().getCategoryName().equals(value));
                return streamFood;
            }
        });
        hashMap.put("subCategory", new FoodFilterMethod() {
            @Override
            public Stream<Food> filter(Stream<Food> streamFood, String value) {
                streamFood.filter(food -> food.getSubCategory().getSubCategoryName().equals(value));
                return streamFood;
            }
        });
        hashMap.put("subSubCategory", new FoodFilterMethod() {
            @Override
            public Stream<Food> filter(Stream<Food> streamFood, String value) {
                streamFood.filter(food -> food.getSubSubCategory().getSubSubCategoryName().equals(value));
                return streamFood;
            }
        });
        return hashMap;
    }

}

