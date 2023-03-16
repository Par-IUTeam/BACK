package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.models.User;
import jakarta.validation.Valid;

import java.util.List;

public class FormRequestBody {
    @Valid
    private User user;

    private List<Food> foods;
}
