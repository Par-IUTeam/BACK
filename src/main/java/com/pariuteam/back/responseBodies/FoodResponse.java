package com.pariuteam.back.responseBodies;

import com.pariuteam.back.models.categories.SubCategory;
import lombok.Data;

@Data
public class FoodResponse {
    private Long foodId;
    private String foodName;
    private SubCategory subCategory;
}
