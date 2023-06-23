package com.pariuteam.back.models;

import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name="food")
@Entity
public class Food {
    @Id
    private Long foodId;

    private String scientificFoodName;
    private String foodName;
    @JoinColumn(name="sub_sub_category_id")
    @ManyToOne
    private SubSubCategory subSubCategory;
    private Integer numberFavourite;

}