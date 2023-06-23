package com.pariuteam.back.responseBodies;

import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import lombok.Data;

@Data
public class FoodResponse {
    private Long foodId;
    private String foodName;
    private SubSubCategory subSubCategory;
    private int nbVentes;
}
