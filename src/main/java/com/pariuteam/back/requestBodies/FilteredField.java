package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FilteredField {
    NAME(FOOD_FILTER_METHODS().get("name")),
    CATEGORY(FOOD_FILTER_METHODS().get("category")),
    SUB_CATEGORY(FOOD_FILTER_METHODS().get("subCategory")),
    SUB_SUB_CATEGORY(FOOD_FILTER_METHODS().get("subSubCategory"));

    FilteredField(FoodFilterMethod foodFilterMethod) {
    }

    public static HashMap<String, FoodFilterMethod> FOOD_FILTER_METHODS() {
        HashMap<String, FoodFilterMethod> hashMap = new HashMap<>();
        hashMap.put("name", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getFoodName().contains(value)).collect(Collectors.toList());
            }
        });

        hashMap.put("category", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getCategory().getCategoryName().equals(value)).collect(Collectors.toList());
            }
        });

        hashMap.put("subCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getSubCategory().getSubCategoryName().equals(value)).collect(Collectors.toList());
            }
        });

        hashMap.put("subSubCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getSubSubCategory().getSubSubCategoryName().equals(value)).collect(Collectors.toList());
            }
        });

        return hashMap;
    }

}

