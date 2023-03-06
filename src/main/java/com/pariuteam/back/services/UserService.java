package com.pariuteam.back.services;

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
    private UserValidator userValidator;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user) {
        if(userValidator.isUserValid(user)){
            if(userRepository.findByMail(user.getMail()).size()==0){
                return userRepository.save(user);
            }
        }
        return null;
    }

}
