package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;

import java.util.stream.Stream;

public abstract class FoodFilterMethod {
    public abstract Stream<Food> filter(Stream<Food> streamFood, String value);
}
