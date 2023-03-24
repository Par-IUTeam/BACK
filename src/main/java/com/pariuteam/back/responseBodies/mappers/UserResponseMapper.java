package com.pariuteam.back.responseBodies.mappers;

import com.pariuteam.back.models.User;
import com.pariuteam.back.responseBodies.Mapper;
import com.pariuteam.back.responseBodies.UserResponseBody;

public class UserResponseMapper extends Mapper<UserResponseBody, User> {
    @Override
    public User toDomain(UserResponseBody actual) {
        User result = new User();
        result.setMail(actual.getMail());
        result.setCityName(actual.getVille());
        result.setPostalCode(actual.getCode_postal());
        result.setUserLastName(actual.getNom());
        result.setUserName(actual.getPrenom());
        result.setBirthdate(actual.getDate());
        result.setPhoneNumber(actual.getTelephone());
        return result;
    }
}
