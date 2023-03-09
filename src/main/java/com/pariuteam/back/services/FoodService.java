package com.pariuteam.back.services;

import com.pariuteam.back.models.Food;
import com.pariuteam.back.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }
}
