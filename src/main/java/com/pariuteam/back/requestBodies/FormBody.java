package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.models.User;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;
@Data
public class FormBody {
    @Valid
    private User user;
    private List<Food> listeAliments;
}
