package com.pariuteam.back.validators;

import com.pariuteam.back.models.User;
import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.beans.JavaBean;


@Service
public class UserValidator {
    public boolean isUserValid(User user) {
        return true;
    }
}
