package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.requestBodies.FoodFilterMethod;
import lombok.Getter;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Getter
public class FilterService{

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
               return list.stream().filter(food -> food.getSubSubCategory().getSubCategory().getCategory().getCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
        hashMap.put("subCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
               return list.stream().filter(food -> food.getSubSubCategory().getSubCategory().getSubCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
        hashMap.put("subSubCategory", new FoodFilterMethod() {
            @Override
            public List<Food> filter(List<Food> list, String value) {
                return list.stream().filter(food -> food.getSubSubCategory().getSubSubCategoryId().equals(Long.valueOf(value))).collect(Collectors.toList());
            }
        });
       hashMap.put("vegan", new FoodFilterMethod() {
           @Override
           public List<Food> filter(List<Food> streamFood, String value) {
               return streamFood.stream().filter(food->{
                   return food.getSubSubCategory().getSubCategory().getCategory().getCategoryId()!=4&&food.getSubSubCategory().getSubCategory().getCategory().getCategoryId()!=5&&!food.getFoodName().contains("viande")&&!food.getSubSubCategory().getSubCategory().getSubCategoryName().contains("viande")&&!food.getSubSubCategory().getSubSubCategoryName().contains("viande");
               }).collect(Collectors.toList());
           }
       });
       hashMap.put("halal", new FoodFilterMethod() {
           @Override
           public List<Food> filter(List<Food> streamFood, String value) {
               return streamFood.stream().filter(food->{
                   return food.getSubSubCategory().getSubCategory().getCategory().getCategoryId()!=4&&!food.getFoodName().contains("viande")&&!food.getSubSubCategory().getSubCategory().getSubCategoryName().contains("viande")&&!food.getSubSubCategory().getSubSubCategoryName().contains("viande")&&food.getSubSubCategory().getSubCategory().getSubCategoryId()!=603||(food.getSubSubCategory().getSubSubCategoryName().contains("halal"));
               }).collect(Collectors.toList());
           }
       });
       hashMap.put("casher", new FoodFilterMethod() {
           @Override
           public List<Food> filter(List<Food> streamFood, String value) {
               return streamFood.stream().filter(food->{
                   return (food.getSubSubCategory().getSubCategory().getCategory().getCategoryId()!=4&&!food.getFoodName().contains("viande")&&!food.getSubSubCategory().getSubCategory().getSubCategoryName().contains("viande")&&!food.getSubSubCategory().getSubSubCategoryName().contains("viande")&&food.getSubSubCategory().getSubCategory().getCategory().getCategoryId()!=5)||(food.getSubSubCategory().getSubSubCategoryName().contains("casher"));
               }).collect(Collectors.toList());
           }
       });
        return hashMap;
   }

}

