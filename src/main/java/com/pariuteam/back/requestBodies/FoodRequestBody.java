package com.pariuteam.back.requestBodies;

import lombok.Data;

@Data
public class FoodRequestBody {
    private Long foodId;
    private String foodName;
    private String scientificFoodName;
    private Long categoryId;
    private Long subCategoryId;
    private Long subSubCategoryId;
}
