package com.pariuteam.back.controllers;

import com.pariuteam.back.models.User;
import com.pariuteam.back.models.categories.SubSubCategory;
import com.pariuteam.back.repositories.categories.SubSubCategoryRepository;
import com.pariuteam.back.services.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }



    @Autowired
    private SubSubCategoryRepository subSubCategoryRepository;
    @GetMapping("multi/sscateg/{id}/{name}")
    private SubSubCategory addSubSubCategory(@PathVariable Long id,@PathVariable String name){
        return subSubCategoryRepository.save(new SubSubCategory(id,name));
    }

}
