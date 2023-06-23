package com.pariuteam.back.repositories;

import com.pariuteam.back.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository  extends JpaRepository<Food,Long> {


    public List<Food>findAll();
}
