package com.pariuteam.back.repositories.categories;

import com.pariuteam.back.models.categories.SubSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSubCategoryRepository extends JpaRepository<SubSubCategory,Long> {

}
