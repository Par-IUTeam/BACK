package com.pariuteam.back.responseBodies.mappers;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.pariuteam.back.models.Food;
import com.pariuteam.back.responseBodies.FoodResponse;
import com.pariuteam.back.responseBodies.Mapper;
import org.hibernate.type.FormatMapper;

import java.util.Map;


public class FoodResponseMapper extends Mapper<Food, FoodResponse> {
    @Override
    public FoodResponse toDomain(Food actual) {
        FoodResponse result = new FoodResponse();
        result.setFoodId(actual.getFoodId());
        result.setSubCategory(actual.getSubCategory());
        result.setFoodName(actual.getFoodName());
        result.setSubSubCategory(actual.getSubSubCategory());
        result.setNbVentes(actual.getNumberFavourite());
        return result;
    }
}
