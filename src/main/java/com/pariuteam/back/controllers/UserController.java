package com.pariuteam.back.controllers;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.models.User;
import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import com.pariuteam.back.repositories.categories.CategoryRepository;
import com.pariuteam.back.repositories.categories.SubCategoryRepository;
import com.pariuteam.back.repositories.categories.SubSubCategoryRepository;
import com.pariuteam.back.responseBodies.UserResponseBody;
import com.pariuteam.back.services.UserService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody UserResponseBody userResponseBody){
        return ResponseEntity.ok().body(userService.addUser(userResponseBody));
    }

    @Autowired
    private SubSubCategoryRepository subSubCategoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("multi/{idCateg}/{nameCateg}/{idSCateg}/{nameSCateg}/{idSSCateg}/{nameSSCateg}/")
    private SubSubCategory addSubSubCategory(@PathVariable(name="idCateg") Long idCateg,@PathVariable(name="nameCateg") String nameCateg,
                                             @PathVariable(name="idSCateg") Long idSCateg,@PathVariable(name="nameSCateg") String nameSCateg,
                                             @PathVariable(name="idSSCateg") Long idSSCateg,@PathVariable(name="nameSSCateg") String nameSSCateg){

        Category category = new Category();
        SubCategory subCategory = new SubCategory();
        SubSubCategory subSubCategory = new SubSubCategory();

        if(!categoryRepository.findAll().stream().anyMatch(categ->{return categ.getCategoryId()==idCateg;})){
            category.setCategoryId(idCateg);
            category.setCategoryName(nameCateg);
        }else category = categoryRepository.findById(idCateg).get();
        if(!subCategoryRepository.findAll().stream().anyMatch(subCateg->{return subCateg.getSubCategoryId()==idSCateg;})){
            subCategory.setSubCategoryId(idSCateg);
            subCategory.setSubCategoryName(nameSCateg);
            subCategory.setCategory(category);
        }else subCategory = subCategoryRepository.findById(idSCateg).get();
        if(!subSubCategoryRepository.findAll().stream().anyMatch(subSubCateg->{return subSubCateg.getSubSubCategoryId()==idSSCateg;})){
            subSubCategory.setSubSubCategoryId(idSSCateg);
            subSubCategory.setSubSubCategoryName(nameSSCateg);
            subSubCategory.setSubCategory(subCategory);
            return subSubCategoryRepository.save(subSubCategory);
        }
        return null;
    }
    @GetMapping("scateg/{idCateg}/{nameCateg}/{idSCateg}/{nameSCateg}/")
    private SubCategory addSubSubCategory(@PathVariable(name="idCateg") String strIdCateg,@PathVariable(name="nameCateg") String nameCateg,
                                             @PathVariable(name="idSCateg") String strIdSCateg,@PathVariable(name="nameSCateg") String nameSCateg){
        Long idCateg = Long.valueOf(strIdCateg);
        Long idSCateg = Long.valueOf(strIdSCateg);

        Category category = new Category();
        SubCategory subCategory = new SubCategory();

        if(!categoryRepository.findAll().stream().anyMatch(categ->{return categ.getCategoryId()==idCateg;})){
            category.setCategoryId(idCateg);
            category.setCategoryName(nameCateg);
            categoryRepository.save(category);
        }else category = categoryRepository.findById(idCateg).get();
        if(!subCategoryRepository.findAll().stream().anyMatch(subCateg->{return subCateg.getSubCategoryId()==idSCateg;})){
            subCategory.setSubCategoryId(idSCateg);
            subCategory.setSubCategoryName(nameSCateg);
            subCategory.setCategory(category);
            return subCategoryRepository.save(subCategory);
        }
        return null;
    }

}
