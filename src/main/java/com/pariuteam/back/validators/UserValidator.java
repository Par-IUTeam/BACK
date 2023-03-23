package com.pariuteam.back.validators;

import com.pariuteam.back.models.User;
import com.pariuteam.back.repositories.UserRepository;
import com.pariuteam.back.validators.bridges.UserIsValid;
import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.beans.JavaBean;


@Service
public class UserValidator {
    public boolean isValid(User user) {
        return UserIsValid.check(user);
    }

    public boolean exist(UserRepository userRepository, User user) {
        return userRepository.findByMail(user.getMail()).size() > 0;
    }
}
