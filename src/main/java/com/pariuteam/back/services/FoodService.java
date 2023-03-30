package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.repositories.FoodRepository;
import com.pariuteam.back.requestBodies.FilteredFoodRequestBody;
import com.pariuteam.back.services.FilterService;
import com.pariuteam.back.requestBodies.FoodRequestBody;
import com.pariuteam.back.responseBodies.FoodResponse;
import com.pariuteam.back.responseBodies.mappers.FoodResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CategoriesService categoriesService;
    public List<FoodResponse> getAllFoods(){
        return new FoodResponseMapper().toDomain(foodRepository.findAll());
    }

    public FoodResponse addFood(FoodRequestBody foodRequestBody) {

        Food food = new Food();
        food.setFoodId(foodRequestBody.getFoodId());
        food.setFoodName(foodRequestBody.getFoodName());
        food.setScientificFoodName(foodRequestBody.getScientificFoodName());
        food.setCategory(categoriesService.getCategorie(foodRequestBody.getCategoryId()));
        food.setSubCategory(categoriesService.getSubCategorie(foodRequestBody.getSubCategoryId()));
        food.setSubSubCategory(categoriesService.getSubSubCategorie(foodRequestBody.getSubSubCategoryId()));

        return new FoodResponseMapper().toDomain(foodRepository.save(food));
    }

    public List<FoodResponse> getFoodList(FilteredFoodRequestBody filteredFoodRequestBody){
        List<Food> list = foodRepository.findAll();
        
        if(filteredFoodRequestBody.getFilters()!=null)
            for(String filterName  : filteredFoodRequestBody.getFilters().keySet()){
                FilterService filter = null;
                String value = filteredFoodRequestBody.getFilters().get(filterName);
                switch(filterName){
                    case "name":
                        filter = FilterService.NAME;
                        break;
                    case "category":
                        filter = FilterService.CATEGORY;
                        break;
                    case "subCategory":
                        filter = FilterService.SUB_CATEGORY;
                        break;
                    case "subSubCategory":
                        filter = FilterService.SUB_SUB_CATEGORY;
                        break;
                }
                list = filter.getFoodFilterMethod().filter(list,value);
            }

        return new FoodResponseMapper().toDomain(list);
    }

    public Food getFood(Long foodId) {
        Optional<Food> food = (foodRepository.findById(foodId));
        if(food.isPresent()){
            return food.get();
        }else throw new IllegalArgumentException();
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }
}
