package com.pariuteam.back.services;

import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import com.pariuteam.back.repositories.categories.CategoryRepository;
import com.pariuteam.back.repositories.categories.SubCategoryRepository;
import com.pariuteam.back.repositories.categories.SubSubCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private SubSubCategoryRepository subSubCategoryRepository;
    public Boolean existCategory(Long categoryId){
        return categoryRepository.findById(categoryId).isPresent();
    }

    public Boolean existSubCategory(Long subCategoryId){
        return subCategoryRepository.findById(subCategoryId).isPresent();
    }

    private Boolean existSubSubCategory(Long subSubCategoryId){
        return subSubCategoryRepository.findById(subSubCategoryId).isPresent();
    }

    public SubSubCategory getSubSubCategorie(Long subSubCategoryId) {
        if(existSubSubCategory(subSubCategoryId)){
            return subSubCategoryRepository.findById(subSubCategoryId).get();
        }
        throw new IllegalArgumentException();
    }
    public Category getCategorie(Long categoryId) {
        if(existCategory(categoryId)){
            return categoryRepository.findById(categoryId).get();
        }
        throw new IllegalArgumentException();
    }
    public SubCategory getSubCategorie(Long subCategoryId) {
        if(existSubSubCategory(subCategoryId)){
            return subCategoryRepository.findById(subCategoryId).get();
        }
        throw new IllegalArgumentException();
    }
}
