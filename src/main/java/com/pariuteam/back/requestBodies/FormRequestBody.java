package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.models.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public class FormRequestBody {
    @Valid
    private User user;
    @Valid
    private List<Food> foods;
}
