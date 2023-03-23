package com.pariuteam.back.services;

import com.pariuteam.back.exceptions.handlers.ApiException;
import com.pariuteam.back.models.User;
import com.pariuteam.back.repositories.UserRepository;
import com.pariuteam.back.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator  userValidator;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) throws ApiException {
        if (!userValidator.isValid(user)) {
            return null;
        }

        if (userValidator.exist(userRepository, user)) {
            throw new ApiException();
        }

        return userRepository.save(user);
    }

}
