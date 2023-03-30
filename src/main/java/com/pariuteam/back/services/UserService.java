package com.pariuteam.back.services;

import com.pariuteam.back.exceptions.handlers.ApiException;
import com.pariuteam.back.models.User;
import com.pariuteam.back.repositories.UserRepository;
import com.pariuteam.back.responseBodies.UserResponseBody;
import com.pariuteam.back.responseBodies.mappers.UserResponseMapper;
import com.pariuteam.back.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator userValidator;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User addUser(UserResponseBody userResponseBody) throws ApiException {
        User user = new UserResponseMapper().toDomain(userResponseBody);
        if(userValidator.isUserValid(user)){
            if(userRepository.findByMail(user.getMail()).size()==0){
                return userRepository.save(user);
            }
            throw new ApiException();
        }
        return null;
    }
    public User getUser(Long userId) throws ApiException {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
            throw new ApiException();
        return user.get();
    }

}
