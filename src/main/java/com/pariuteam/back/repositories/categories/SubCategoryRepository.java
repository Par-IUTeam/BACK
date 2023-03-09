package com.pariuteam.back.repositories.categories;

import com.pariuteam.back.models.categories.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

}
