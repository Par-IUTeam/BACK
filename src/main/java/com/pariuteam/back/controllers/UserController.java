package com.pariuteam.back.controllers;

import com.pariuteam.back.models.User;
import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import com.pariuteam.back.repositories.categories.CategoryRepository;
import com.pariuteam.back.repositories.categories.SubCategoryRepository;
import com.pariuteam.back.repositories.categories.SubSubCategoryRepository;
import com.pariuteam.back.services.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController @RequestMapping("/users") public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @Autowired
    private SubSubCategoryRepository subSubCategoryRepository;

    @GetMapping("multi/sscateg/{id}/{name}")
    private SubSubCategory addSubSubCategory(@PathVariable Long id, @PathVariable String name) {
        return subSubCategoryRepository.save(new SubSubCategory(id, name));
    }

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @GetMapping("multi/scateg/{id}/{name}")
    private SubCategory addSubCategory(@PathVariable Long id, @PathVariable String name) {
        return subCategoryRepository.save(new SubCategory(id, name));
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("multi/categ/{id}/{name}")
    private Category addCategory(@PathVariable Long id, @PathVariable String name) {
        return categoryRepository.save(new Category(id, name));
    }

}
