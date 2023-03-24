package com.pariuteam.back.requestBodies;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.models.User;
import com.pariuteam.back.responseBodies.UserResponseBody;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;
@Data
public class FormBody {
    @Valid
    private UserResponseBody user;
    private List<Long> listeAliments;
}
