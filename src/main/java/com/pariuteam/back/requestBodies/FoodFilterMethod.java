package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;

import java.util.List;

public abstract class FoodFilterMethod {
    public abstract List<Food> filter(List<Food> streamFood, String value);
}
