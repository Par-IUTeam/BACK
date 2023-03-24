package com.pariuteam.back.repositories;

import com.pariuteam.back.models.FavouriteFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface FavouriteFoodRepository extends JpaRepository<FavouriteFood, Long> {

}